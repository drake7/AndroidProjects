package com.example.popularmovies;

public class Movie {

    private String title;
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    private double rating;
    private String overview;

    public Movie(String title, String poster, double rating, String overview) {
        this.title = title;
        this.poster = poster;
        this.rating = rating;
        this.overview = overview;
    }

}
