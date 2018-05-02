package com.twu.biblioteca;

import java.util.ArrayList;

public class BookController {
    ArrayList<Book> books = new ArrayList<Book>();


    public BookController() {
        books.add(new Book("TDD", "Kent Beck", 2000));
        books.add(new Book("Clean Code", "Robert Cecil Martin", 2008));
        books.add(new Book("Simon vs. the Homo Sapiens Agenda", "Becky Albertalli", 2015));
        books.add(new Book("Wonder", "R.J. Palacio", 2012));
    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public void checkoutBook(Book book) throws BookReservationException{
        int index = books.indexOf(book);

        if(books.get(index).isBooked()){
            throw new BookReservationException("This book is already booked.");
        } else {
            books.get(index).book();
        }
    }

    public void returnBook(Book book) throws BookReservationException{
        int index = books.indexOf(book);

        if(books.get(index).isBooked()){
            books.get(index).unbook();
        } else {
            throw new BookReservationException("This book is not booked to be returned.");
        }
    }

}
