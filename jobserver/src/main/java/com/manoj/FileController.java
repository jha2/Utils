package com.manoj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@EnableAutoConfiguration
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileDownloadService fileDownloadService;

    /*
     * Download the file
     * @return 200 code
     */
    @RequestMapping(value = "/download/{filename}", method = GET)
    @ResponseBody
    ResponseEntity<?> getFile(@PathVariable String fileName) throws Exception {
        logger.info("Recieved request for downloading file: {} ", fileName);
        boolean status = fileDownloadService.getFile(fileName);
        return new ResponseEntity(status, HttpStatus.OK);
    }
}
