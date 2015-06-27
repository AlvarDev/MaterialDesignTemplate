package com.gdglima.materialdesigntemplate.entities;

import java.io.Serializable;

public class OptionEntity implements Serializable{

    private String title;
    private String cap;
    private int idColor;

    public OptionEntity(String title, String cap, int idColor) {
        this.title = title;
        this.cap = cap;
        this.idColor = idColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    @Override
    public String toString() {
        return "OptionEntity{" +
                "title='" + title + '\'' +
                ", cap='" + cap + '\'' +
                ", idColor=" + idColor +
                '}';
    }
}
