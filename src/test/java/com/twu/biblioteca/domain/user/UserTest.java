package com.twu.biblioteca.domain.user;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Test
    public void shouldReturnLibrarianPassword() {
        user = new User().createLibrarian("123-1234", "12345");

        assertEquals("12345", user.getPassword());
    }

    @Test
    public void shouldReturnLibrarianNumber() {
        user = new User().createLibrarian("123-1234", "12345");

        assertEquals("123-1234", user.getLibraryNumber());
    }

    @Test
    public void shouldReturnCustomerEmailAddress() {
        user = new User().createCustomer("Lorrane", "lidevic@thoughtworks.com", "(31) 99999-9999", "12345");

        assertEquals("lidevic@thoughtworks.com", user.getEmailAddress());
    }

    @Test
    public void shouldReturnCostumerInformation() {
        user = new User().createCustomer("Lorrane", "lidevic@thoughtworks.com", "(31) 99999-9999", "12345");

        assertEquals("Lorrane - lidevic@thoughtworks.com - (31) 99999-9999", user.getCostumerInformation());
    }

    @Test
    public void shouldReturnIfIsLibrarian() {
        user = new User().createLibrarian("123-1234", "12345");

        assertEquals(true, user.isLibrarian());
    }
}