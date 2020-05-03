package com.example.healthguide;

import java.io.Serializable;

public class Note implements Serializable {
    private int id;
    private String desc;
    private String date;

    public Note(int id, String desc, String date) {
        this.id = id;
        this.desc = desc;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
