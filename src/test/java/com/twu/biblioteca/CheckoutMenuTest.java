package com.twu.biblioteca;

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

//        bookController = mock(BookController.class);
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
        //arrange
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //action
        checkoutMenu.print();

        //assert
        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldReturnAnIndexOutOfRangeException() {
        //arrange
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //action
        try {
            checkoutMenu.print();
            fail( "A exception was expected here since we are trying to access an Index Out Of Bounds." );
        } catch (IndexOutOfBoundsException expectedException) {
            //assert
            assertThat(outContent.toString(), containsString("1 - TDD"));
        }

    }

    @Test
    public void getName() {
        //action
        checkoutMenu.getName();

        //assert
        assertThat(outContent.toString(), containsString("2 - Checkout BookController"));

    }
}