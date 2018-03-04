package com.manoj;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JobServer.class)
@TestPropertySource(locations = "classpath:application.properties")
public class TestFileDownloadService {

    @Value("$(ftp.server.name)")
    private String ftpServer;

    @Value("$(localhost.destination.path)")
    private String destinationPath;

    @Value("$(ftp.server.sourcepath)")
    private String sourcePath;


    private static String fname = "NASA_access_log_Jul95.gz";
    // One way to test the file download services is to mock the FTPClient  and
    // then set its various attributes.  This will take time to  develop the test case.
    @Mock
    private FTPClient ftpClient = new FTPClient();

    @Mock
    private FileDownloadService fileDownloadService;



    @Before
    public void setUp() throws IOException {
        initMocks(this);
    }



    @Test
    public void shouldDownloadFile() throws DownloadDatasetException {
        when(fileDownloadService.getFile(fname)).thenReturn(true);
        boolean status = fileDownloadService.getFile(fname);
        assertTrue(status);
    }

    @Test
    public void shouldGetFile() throws DownloadDatasetException {
        when(ftpClient.getReplyCode()).thenReturn(200);
        when(ftpClient.isConnected()).thenReturn(true);
//        when(ftpClient.retrieveFile(isA(String.class), isA(OutputStream.class))).thenReturn(true);
        boolean status = fileDownloadService.getFile(fname);
        assertFalse(status);


    }

}
