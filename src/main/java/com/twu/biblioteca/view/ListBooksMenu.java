package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.BookController;

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
    public String getName() {
        return "List Books";
    }
}
