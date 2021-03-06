package com.twu.biblioteca.domain.book;

import com.twu.biblioteca.domain.user.User;

public class Book {
    private String name;
    private String author;

    private User userWhoCheckedOut;
    private int year;
    private boolean booked = false;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return name + " - " + author + " - " + year;
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

    public void setUserWhoCheckedOut(User user) {
        this.userWhoCheckedOut = user;
    }

    public User getUserWhoCheckedOut() {
        return userWhoCheckedOut;
    }
}
