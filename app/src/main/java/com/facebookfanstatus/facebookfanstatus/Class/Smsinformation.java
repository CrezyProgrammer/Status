package com.facebookfanstatus.facebookfanstatus.Class;

public class Smsinformation {

    private String serial;
    private String title;
    private String details;
    private int catogory;

    public Smsinformation(int catogory,String serial, String title, String details) {
        this.serial = serial;
        this.catogory=catogory;
        this.title = title;
        this.details = details;
    }

    public int getCatogory() {
        return catogory;
    }

    public void setCatogory(int catogory) {
        this.catogory = catogory;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
