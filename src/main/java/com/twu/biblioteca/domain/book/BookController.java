package com.twu.biblioteca.domain.book;

import com.twu.biblioteca.domain.auth.Auth;
import com.twu.biblioteca.domain.user.User;

import java.util.ArrayList;

public class BookController {
    ArrayList<Book> books = new ArrayList<Book>();
    private Auth auth;

    public BookController() {
        auth = new Auth();

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

    public void checkoutBook(Book book) throws BookReservationException {
        int index = books.indexOf(book);

        if(books.get(index).isBooked()){
            throw new BookReservationException("That book is not available");
        } else {
            books.get(index).book();
            books.get(index).setUserWhoCheckedOut(auth.getLoggedUser());
        }
    }

    public ArrayList<User> whoCheckedOutABook() {
        ArrayList<User> users = new ArrayList<>();//todos que checkaram um livro

        for(int i = 0; i < books.size(); i++) {
            if (books.get(i).getUserWhoCheckedOut() != null) {
                users.add(books.get(i).getUserWhoCheckedOut());
            }
        }

        return users;
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
