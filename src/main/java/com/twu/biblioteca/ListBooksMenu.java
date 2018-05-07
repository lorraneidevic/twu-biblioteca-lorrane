package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksMenu implements Option {
    private BookController bookController;

    public ListBooksMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print() {
        ArrayList<Book> availableBooks = bookController.listAvailableBooks();

        if(availableBooks.size() == 0) {
            System.out.println("\nThere is no book left to checkout.");
        } else {
            for (int i = 0; i < availableBooks.size(); i++) {
                System.out.println((i + 1) + " - " + availableBooks.get(i).getName());
            }
        }
    }

    @Override
    public void getName() {
        System.out.println("1 - List Books");
    }
}
