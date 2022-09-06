package com.example.myfinalproject;

import android.widget.TextView;

import java.io.Serializable;

public class Items implements Serializable {

    String name;
    double price;
    String image;
    String genre;
    String authorname;
    String description;

    public Items(String name, double price, String image, String genre, String authorname, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.genre = genre;
        this.authorname = authorname;
        this.description = description;
    }

    public Items() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
