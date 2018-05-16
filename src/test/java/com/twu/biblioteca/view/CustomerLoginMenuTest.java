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

public class CustomerLoginMenuTest {
    private CustomerLoginMenu customerLoginMenu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

        customerLoginMenu = new CustomerLoginMenu();
    }

    @After
    public void tearDown(){
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void shouldValidateLogin() {
        User user = new User().createCustomer("Lorrane", "lidevic@thoughtworks.com", "(31) 99999-9999", "12345");

        customerLoginMenu.validateLogin(user);

        assertThat(outContent.toString(), containsString("You're logged in"));
    }

    @Test
    public void getName() {
        assertThat(customerLoginMenu.getName(), containsString("Customer Login"));
    }
}