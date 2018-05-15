package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.auth.Auth;
import com.twu.biblioteca.domain.user.User;

import java.util.Scanner;

public class CustomerLoginMenu implements Option {
    Auth auth;

    public CustomerLoginMenu() {
        this.auth = new Auth();
    }

    @Override
    public void print() {
        User user = getUserCredentials();

        validateLogin(user);
    }

    private User getUserCredentials() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type your email address: ");
        String emailAddress = scanner.nextLine();

        System.out.println("Please type your password: ");
        String password = scanner.nextLine();

        return new User().createCustomer("Lorrane", emailAddress, "(31) 99999-9999", password);
    }

    private void validateLogin(User user) {
        if(auth.canUserLogin(user)) {
            System.out.println("You're logged in!");
        } else {
            System.out.println("Email Address or Password incorrect.");
            print();
        }
    }

    @Override
    public String getName() {
        return "Customer Login";
    }
}
