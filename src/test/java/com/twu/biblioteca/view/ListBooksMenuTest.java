package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.book.BookController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksMenuTest {

    private ListBooksMenu listBooksMenu;
    private BookController bookController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

        bookController = new BookController();
        listBooksMenu = new ListBooksMenu(bookController);
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void print() {
        listBooksMenu.print();

        assertThat(outContent.toString(),containsString("1 - TDD"));
    }

    @Test
    public void shouldReturnAvailableBooks(){
        listBooksMenu.print();

        assertThat(outContent.toString(),containsString("1 - TDD"));
    }

    @Test
    public void getName() {
        String menuName = listBooksMenu.getName();

        assertThat(menuName,containsString("List Books"));
    }
}