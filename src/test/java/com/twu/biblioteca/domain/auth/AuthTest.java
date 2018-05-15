package com.twu.biblioteca.domain.auth;

import com.twu.biblioteca.domain.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthTest {
    private Auth auth;

    @Before
    public void setUp(){
        auth = new Auth();
    }

    @Test
    public void canCustomerLogin() {
        User user = new User().createCustomer("Lorrane", "lidevic@thoughtworks.com", "(31) 99850-4794");

        boolean didUserLoggedIn = auth.canUserLogin(user);

        assertEquals(true, didUserLoggedIn);
    }

    @Test
    public void canLibrarianLogin() {
        User user = new User().createLibrarian("Lorrane");

        boolean didUserLoggedIn = auth.canUserLogin(user);

        assertEquals(true, didUserLoggedIn);
    }
}