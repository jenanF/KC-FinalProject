package com.example.myfinalproject;

public class Freebo {

    String image;
    String name;
    String genre;

    public Freebo(String image, String name, String genre) {
        this.image = image;
        this.name = name;
        this.genre = genre;
    }

    public Freebo() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
