package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibrarianLoginMenuTest {
    private LibrarianLoginMenu librarianLoginMenu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private User user;


    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

        librarianLoginMenu = new LibrarianLoginMenu();
    }

    @After
    public void tearDown(){
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void shouldValidateLogin() {
        User user = new User().createLibrarian("123-1234", "12345");

        librarianLoginMenu.validateLogin(user);

        assertThat(outContent.toString(), containsString("You're logged in"));
//        assertEquals("123-1234", user.getLibraryNumber());
    }

    @Test
    public void getName() {
        assertThat(librarianLoginMenu.getName(), containsString("Librarian Login"));
    }
}