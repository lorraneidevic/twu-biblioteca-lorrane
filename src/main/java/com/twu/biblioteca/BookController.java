package com.twu.biblioteca;

import java.lang.reflect.Array;
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

    public ArrayList<Book> listAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList<Book> allBooks = this.listBooks();

        for(int i = 0; i < allBooks.size(); i++) {
            if (!allBooks.get(i).isBooked()) {
                availableBooks.add(allBooks.get(i));
            }
        }

        return availableBooks;
    }

    public ArrayList<Book> listUnavailableBooks() {
        ArrayList<Book> unavailableBooks = new ArrayList<>();
        ArrayList<Book> allBooks = this.listBooks();

        for(int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i).isBooked()) {
                unavailableBooks.add(allBooks.get(i));
            }
        }

        return unavailableBooks;
    }

    public void printAvailableBooks() {
        ArrayList<Book> availableBooks = listAvailableBooks();

        if(availableBooks.size() == 0) {
            System.out.println("\nThere is no book left to checkout.");
        } else {
            for (int i = 0; i < availableBooks.size(); i++) {
                System.out.println((i + 1) + " - " + availableBooks.get(i).getName());
            }
        }
    }

    public void printUnavailableBooks() {
        ArrayList<Book> unavailableBooks = listUnavailableBooks();

        if(unavailableBooks.size() == 0) {
            System.out.println("\nThere is no book left to return.");
        } else {
            for (int i = 0; i < unavailableBooks.size(); i++) {
                System.out.println((i + 1) + " - " + unavailableBooks.get(i).getName());
            }
        }
    }

    public void checkoutBook(Book book) throws BookReservationException{
        int index = books.indexOf(book);

        if(books.get(index).isBooked()){
            throw new BookReservationException("That book is not available");
        } else {
            books.get(index).book();
        }
    }

    public void returnBook(Book book) throws BookReservationException{
        int index = books.indexOf(book);

        if(books.get(index).isBooked()){
            books.get(index).unbook();
        } else {
            throw new BookReservationException("That is not a valid book to return");
        }
    }

}
