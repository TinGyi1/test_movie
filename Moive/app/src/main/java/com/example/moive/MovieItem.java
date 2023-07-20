package com.example.moive;

public class MovieItem {

    String title;
    String name;
    String review;
    int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public MovieItem(String title, String name, String review, int image) {
        this.title = title;
        this.name = name;
        this.review = review;
        this.image = image;
    }
}
