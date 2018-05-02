package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookControllerTest {
    private BookController bookControllerTestClass;

    @Before
    public void setUp() throws Exception{
        bookControllerTestClass = new BookController();
    }

    @Test
    public void testListBooks(){
        //initialize
        List<String> books = new ArrayList<String>();
        books.add("TDD");
        books.add("Clean Code");
        books.add("Love, Simon");
        books.add("Wonder");

        //action
        List<String> testBooks = bookControllerTestClass.listBooks();

        //asserts
        assertEquals(books.size(), testBooks.size());
        assertEquals(books.get(0), testBooks.get(0));
        assertEquals(books.get(1), testBooks.get(1));
        assertEquals(books.get(2), testBooks.get(2));
        assertEquals(books.get(3), testBooks.get(3));
    }

    @Test
    public void testCheckoutBook(){

    }
}
