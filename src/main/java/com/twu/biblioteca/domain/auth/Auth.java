package com.twu.biblioteca.domain.auth;

import com.twu.biblioteca.domain.user.User;

public class Auth {

    private static User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        Auth.loggedUser = loggedUser;
    }

    public boolean canUserLogin(User user) {

        if(user.isLibrarian()) {
            return this.canLibrarianLogIn(user);
        } else {
            return this.canCustomerLogIn(user);
        }

    }

    private boolean canLibrarianLogIn(User user) {
        if(user.getLibraryNumber().trim().equals("123-1234") && user.getPassword().trim().equals("12345")) {
            setLoggedUser(user);
            return true;
        }

        return false;
    }

    private boolean canCustomerLogIn(User user) {
        if(user.getEmailAddress().trim().equals("lidevic@thoughtworks.com") && user.getPassword().trim().equals("12345")) {
            setLoggedUser(user);
            return true;
        }

        return false;
    }
}
