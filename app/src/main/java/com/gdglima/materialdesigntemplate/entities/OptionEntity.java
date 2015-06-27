package com.gdglima.materialdesigntemplate.entities;

import java.io.Serializable;

public class OptionEntity implements Serializable{

    private String title;
    private int idImage;

    public OptionEntity(String title, int idImage) {
        this.title = title;
        this.idImage = idImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "OptionEntity{" +
                "title='" + title + '\'' +
                ", idImage=" + idImage +
                '}';
    }
}
