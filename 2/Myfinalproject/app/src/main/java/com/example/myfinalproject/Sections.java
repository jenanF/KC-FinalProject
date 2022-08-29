package com.example.myfinalproject;

import java.io.Serializable;

public class Sections implements Serializable {

    private int image;
    private String name;

    public Sections() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sections (String name, int image){

        this.image=image;
        this.name=name;

    }
}
