package com.twu.biblioteca.domain.user;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Test
    public void shouldReturnLibrarianName() {
        user = new User().createLibrarian("Lorrane");

        assertEquals("Lorrane", user.getName());
    }

    @Test
    public void shouldReturnLibrarianPassword() {
        user = new User().createLibrarian("Lorrane");

        assertEquals("12345", user.getPassword());
    }

    @Test
    public void shouldReturnLibrarianNumber() {
        user = new User().createLibrarian("Lorrane");

        assertEquals("123-1234", user.getLibraryNumber());
    }

    @Test
    public void shouldReturnCustomerPhoneNumber() {
        user = new User().createCustomer("Lorrane", "lidevic@thoughtworks.com", "(31) 99850-4794");

        assertEquals("123-1234", user.getLibraryNumber());
    }
}