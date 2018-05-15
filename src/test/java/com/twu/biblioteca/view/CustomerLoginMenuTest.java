package com.twu.biblioteca.view;

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
    public void print() {
//        String input1 = "lidevic@thoughtworks.com";
//        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
//        System.setIn(in1);
//        String input2 = "12345";
//        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
//        System.setIn(in2);
//
//        customerLoginMenu.print();
//
//        assertThat(outContent.toString(), containsString("You're logged in"));
    }

    @Test
    public void getName() {
        assertThat(customerLoginMenu.getName(), containsString("Customer Login"));
    }
}