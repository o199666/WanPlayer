package com.wan.player.bean;

import android.graphics.Bitmap;

public class LocalDataBean {
    private String fileName;
    private String fileTime;
    private String fileSize;
    private String filePtah;
    private Bitmap fileImage;

    public LocalDataBean(String fileName, String fileTime, String fileSize, String filePtah, Bitmap fileImage) {
        this.fileName = fileName;
        this.fileTime = fileTime;
        this.fileSize = fileSize;
        this.filePtah = filePtah;
        this.fileImage = fileImage;
    }

    public Bitmap getFileImage() {
        return fileImage;
    }

    public void setFileImage(Bitmap fileImage) {
        this.fileImage = fileImage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileTime() {
        return fileTime;
    }

    public void setFileTime(String fileTime) {
        this.fileTime = fileTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePtah() {
        return filePtah;
    }

    public void setFilePtah(String filePtah) {
        this.filePtah = filePtah;
    }
}
