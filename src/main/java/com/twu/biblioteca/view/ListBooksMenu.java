package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.book.Book;
import com.twu.biblioteca.domain.book.BookController;

import java.util.ArrayList;

public class ListBooksMenu implements Option {
    private BookController bookController;

    public ListBooksMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print() {
        printAvailableBooks();
    }

    public void printAvailableBooks() {
        ArrayList<Book> books = bookController.listBooks();

        if(hasAvailableBooks()) {
            System.out.println("\nAvailable books:");
            for (int i = 0; i < books.size(); i++) {
                if(!books.get(i).isBooked()) {
                    System.out.println((i + 1) + " - " + books.get(i).getName());
                }
            }
        } else {
            System.out.println("\nThere is no book left to checkout.");
        }
    }

    private boolean hasAvailableBooks(){
        return bookController.listAvailableBooks().size() > 0;
    }

    @Override
    public String getName() {
        return "List Books";
    }
}
