package com.manoj;

import org.springframework.http.HttpStatus;

public class DownloadDatasetException extends Exception {

    private HttpStatus status;
    private String description;
    private String errorType;

    public DownloadDatasetException(String e){
        super(e);
    }
    public DownloadDatasetException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadDatasetException(String message, HttpStatus status, String description, String errorType) {
        super(message);
        this.status = status;
        this.description = description;
        this.errorType = errorType;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
