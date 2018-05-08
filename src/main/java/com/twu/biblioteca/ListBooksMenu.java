package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksMenu implements Option {
    private BookController bookController;

    public ListBooksMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print() {
        bookController.printAvailableBooks();
    }

    @Override
    public void getName() {
        System.out.println("1 - List Books");
    }
}
