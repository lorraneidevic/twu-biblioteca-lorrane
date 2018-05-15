package com.twu.biblioteca.domain.user;

public class User {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private boolean isLibrarian = false;

    public User createLibrarian(String libraryNumber, String password) {
        this.isLibrarian = true;
        this.libraryNumber = libraryNumber;
        this.password = password;

        return this;
    }

    public User createCustomer(String name, String emailAddress, String phoneNumber, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;

        return this;
    }

    public String getCostumerInformation() {
        return name + " - " + emailAddress + " - " + phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
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
