package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnTheBookName() {
        //arrange
        Book book = new Book("Wonder");

        //action
        String bookName = book.getName();

        //assert
        assertEquals("Wonder", bookName);
    }

    @Test
    public void shouldNotBeBookedWhenCreated() {
        //arrange
        Book book = new Book("Wonder");

        //action
        boolean bookStatus = book.isBooked();

        //assert
        assertEquals(false, bookStatus);
    }

    @Test
    public void shouldBookABook() {
        //arrange
        Book book = new Book("Wonder");

        //action
        book.book();

        //assert
        assertEquals(true, book.isBooked());
    }

    @Test
    public void shouldUnbookABook() {
        //arrange
        Book book = new Book("Wonder");
        book.book();

        //action
        book.unbook();

        //assert
        assertEquals(false, book.isBooked());
    }
}