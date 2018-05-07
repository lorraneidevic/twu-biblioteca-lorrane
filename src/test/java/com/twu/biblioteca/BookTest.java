package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnTheBookName() {
        //arrange
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        //action
        String bookName = book.getName();

        //assert
        assertEquals("Wonder", bookName);
    }

    @Test
    public void shouldNotBeBookedWhenCreated() {
        //arrange
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        //action
        boolean bookStatus = book.isBooked();

        //assert
        assertEquals(false, bookStatus);
    }

    @Test
    public void shouldBookABook() {
        //arrange
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        //action
        book.book();

        //assert
        assertEquals(true, book.isBooked());
    }

    @Test
    public void shouldUnbookABook() {
        //arrange
        Book book = new Book("Wonder", "R.J. Palacio", 2012);
        book.book();

        //action
        book.unbook();

        //assert
        assertEquals(false, book.isBooked());
    }

    @Test
    public void shouldReturnTheBookDetails() {
        //arrange
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        //action
        String bookDetails = book.getDetails();

        //assert
        assertEquals("Wonder - R.J. Palacio - 2012", bookDetails);
    }
}