package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.auth.Auth;
import com.twu.biblioteca.domain.user.User;

import java.util.Scanner;

public class LibrarianLoginMenu implements Option {
    Auth auth;

    public LibrarianLoginMenu() {
        this.auth = new Auth();
    }

    @Override
    public void print() {
        User user = getUserCredentials();

        validateLogin(user);
    }

    private User getUserCredentials() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type your Librarian Number (xxx-xxxx): ");
        String librarianNumber = scanner.nextLine();

        System.out.println("Please type your password: ");
        String password = scanner.nextLine();

        return new User().createLibrarian(librarianNumber, password);
    }

    private void validateLogin(User user) {
        if(auth.canUserLogin(user)) {
            System.out.println("You're logged in!");
        } else {
            System.out.println("Librarian Number or Password incorrect.");
            print();
        }
    }

    @Override
    public String getName() {
        return "Librarian Login";
    }
}
