package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.book.BookController;
import com.twu.biblioteca.domain.user.User;

import java.util.ArrayList;

public class WhoCheckedOutABookMenu implements Option{

    private BookController bookController;

    public WhoCheckedOutABookMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print() {
        ArrayList<User> users = bookController.whoCheckedOutABook();

        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getCostumerInformation());
        }
    }

    @Override
    public String getName() {
        return "Who Checked Out a Book";
    }
}
