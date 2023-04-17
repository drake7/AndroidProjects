package com.example.imagesapp;

public class Item {

    private int numberOfLikes;
    private String imageUrl;
    private String tags;


    public Item(String imageUrl, String tags, int numberOfLikes) {
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.numberOfLikes = numberOfLikes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTags() {
        return tags;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

}
