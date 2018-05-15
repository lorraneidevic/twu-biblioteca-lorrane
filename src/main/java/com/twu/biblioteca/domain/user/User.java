package com.twu.biblioteca.domain.user;

public class User {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private boolean isLibrarian = false;

    public User createLibrarian(String name) {
        this.name = name;
        this.isLibrarian = true;
        this.libraryNumber = "123-1234";
        this.password = "12345";

        return this;
    }

    public User createCustomer(String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = "12345";

        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }
}
