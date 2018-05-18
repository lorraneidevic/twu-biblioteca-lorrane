package com.twu.biblioteca.domain.movie;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int movieRating = 0;
    private boolean booked = false;

    private String userWhoCheckedOut;

    public Movie(String name, int year, String director, int movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.booked = booked;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        //name, year, director and movie rating (from 1-10 or unrated).
        return name + " - " + year + " - " + director + " - " + (movieRating==0 ? "unrated" : movieRating);
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public void unbook() {
        this.booked = false;
    }

    public void setUserWhoCheckedOut(String userWhoCheckedOut) {
        this.userWhoCheckedOut = userWhoCheckedOut;
    }

    public String getUserWhoCheckedOut() {
        return userWhoCheckedOut;
    }

}
