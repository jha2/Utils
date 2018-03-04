package com.manoj;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileDownloadService {

    private static final Logger logger = LoggerFactory.getLogger(FileDownloadService.class);

    @Value("$(ftp.server.name)")
    private String ftpServer;

    @Value("$(localhost.destination.path)")
    private String destinationPath;

    @Value("$(ftp.server.sourcepath)")
    private String sourcePath;

    private FTPClient ftpClient;

    public boolean getFile(String fileName) throws DownloadDatasetException {
        ftpClient = new FTPClient();
        boolean status = false;
        try {
            ftpClient.connect(ftpServer);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String remoteFile = sourcePath + "/" + fileName;
            File downloadFile = new File(destinationPath + "/" + fileName);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
            logger.info("Trying to download file from remote {} to local {}", remoteFile,
                    downloadFile.getPath());
            status = ftpClient.retrieveFile(remoteFile, outputStream);
            outputStream.close();

            if (status) {
                logger.info("Remote file {} downloaded to {}", remoteFile, downloadFile.getPath());
            }

        } catch (IOException e) {

            logger.error("Problem in downloading file from FTP server: {}, destinationPath: {}, issue: {}", ftpServer, destinationPath, e.getMessage());
            throw new DownloadDatasetException(e.getMessage(), e.getCause());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                }

            } catch (IOException ex) {
                logger.error("Issue in closing FTP client connection: {}", printStackTrace(ex));
            }
        }

        return status;
    }

    private static String printStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        return sStackTrace;
    }

}
