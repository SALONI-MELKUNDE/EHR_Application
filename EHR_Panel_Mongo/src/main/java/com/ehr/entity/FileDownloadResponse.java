package com.ehr.entity;

public class FileDownloadResponse {
    private String message;
    private byte[] fileData;

    public FileDownloadResponse(String message, byte[] fileData) {
        this.message = message;
        this.fileData = fileData;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}



