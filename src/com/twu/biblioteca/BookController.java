package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    ArrayList<String> books = new ArrayList<String>();


    public BookController() {
        books.add("TDD");
        books.add("Clean Code");
        books.add("Love, Simon");
        books.add("Wonder");
    }

    public ArrayList<String> listBooks() {
        return books;
    }

    public void checkoutBook() {

    }

    public void returnBook() {

    }

}
