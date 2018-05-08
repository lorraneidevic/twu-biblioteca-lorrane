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

public class ReturnBookMenuTest {

    private ReturnBookMenu returnBookMenu;
    private BookController bookController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

//        bookController = mock(BookController.class);
        bookController = new BookController();
        returnBookMenu = new ReturnBookMenu(bookController);
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
        returnBookMenu.print();

        //assert
        assertThat(outContent.toString(), containsString("There is no book left to return"));
    }

    @Test
    public void getName() {
        //action
        returnBookMenu.getName();

        //assert
        assertThat(outContent.toString(), containsString("3 - Return a Book"));
    }
}