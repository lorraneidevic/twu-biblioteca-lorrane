package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListBooksMenuTest {

    private ListBooksMenu listBooksMenu;
    private BookController bookController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

//        bookController = mock(BookController.class);
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
        //action
        listBooksMenu.print();

        //assert
//        verify(bookController).printAvailableBooks();
        assertThat(outContent.toString(),containsString("1 - TDD"));
    }

    @Test
    public void shouldReturnAvailableBooks(){//criar teste pra qdo n tem nenhum livro - assert output
        //arrange
//        ArrayList<Book> books = new ArrayList<Book>();
//        books.add(new Book("TDD", "Kent Beck", 2000));
//        books.add(new Book("Clean Code", "Robert Cecil Martin", 2008));
//        books.add(new Book("Simon vs. the Homo Sapiens Agenda", "Becky Albertalli", 2015));
//        books.add(new Book("Wonder", "R.J. Palacio", 2012));
//        when(bookController.listAvailableBooks()).thenReturn(books);

        //action
        listBooksMenu.print();

        //assert
        assertThat(outContent.toString(),containsString("1 - TDD"));
    }

    @Test
    public void shouldNotReturnAvailableBooks(){
        //arrange
//        ArrayList<Book> books = new ArrayList<Book>();
//        when(bookController.listAvailableBooks()).thenReturn(books);

        //action
//        listBooksMenu.print();

        //assert
//        assertThat(outContent.toString(),containsString("There is no book left to checkout"));
    }

    @Test
    public void getName() {
        //action
        listBooksMenu.getName();

        //assert
        assertThat(outContent.toString(),containsString("1 - List Books"));
    }
}