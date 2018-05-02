package com.twu.biblioteca;

public class Book {
    private String name;
    private boolean booked = false;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
}
