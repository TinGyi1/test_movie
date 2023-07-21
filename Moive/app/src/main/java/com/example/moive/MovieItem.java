package com.example.moive;

public class MovieItem {

    String title;
    String year;
    String imb;
    String image;

    public MovieItem(String title, String year, String imb, String image) {
        this.title = title;
        this.year = year;
        this.imb = imb;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImb() {
        return imb;
    }

    public void setImb(String imb) {
        this.imb = imb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
