package com.example.adapterviewflipperapp;

public class ItemsModel {
    int flagimage;
    String flagname;

    public ItemsModel(int flagimage, String flagname) {
        this.flagimage = flagimage;
        this.flagname = flagname;
    }

    public int getFlagimage() {
        return flagimage;
    }

    public void setFlagimage(int flagimage) {
        this.flagimage = flagimage;
    }

    public String getFlagname() {
        return flagname;
    }

    public void setFlagname(String flagname) {
        this.flagname = flagname;
    }
}
