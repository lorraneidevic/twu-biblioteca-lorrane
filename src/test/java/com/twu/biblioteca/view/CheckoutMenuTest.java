package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.BookController;
import com.twu.biblioteca.view.CheckoutMenu;
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
import static org.mockito.Mockito.verify;

public class CheckoutMenuTest {

    private CheckoutMenu checkoutMenu;
    private BookController bookController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

        bookController = new BookController();
        checkoutMenu = new CheckoutMenu(bookController);
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void print() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutMenu.print();

        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldReturnAnIndexOutOfRangeException() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            checkoutMenu.print();
            assertThat(outContent.toString(), containsString("That is not a valid book to return"));
        } catch (IndexOutOfBoundsException expectedException) {
            fail("Expection should be treated correctly");
        }

    }

    @Test
    public void getName() {
        String menuName = checkoutMenu.getName();

        assertThat(menuName, containsString("Checkout a Book"));

    }
}