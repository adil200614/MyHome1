package com.example.myhome1.model;

import java.io.Serializable;

public class TaskModel implements Serializable {

    private String title, desc;
    private int imageview;

    public TaskModel(String title, String desc, int imageview) {
        this.title = title;
        this.desc = desc;
        this.imageview = imageview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }
}
