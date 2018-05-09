package com.twu.biblioteca.domain.book;

import com.twu.biblioteca.domain.book.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnTheBookName() {
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        String bookName = book.getName();

        assertEquals("Wonder", bookName);
    }

    @Test
    public void shouldNotBeBookedWhenCreated() {
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        boolean bookStatus = book.isBooked();

        assertEquals(false, bookStatus);
    }

    @Test
    public void shouldBookABook() {
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        book.book();

        assertEquals(true, book.isBooked());
    }

    @Test
    public void shouldUnbookABook() {
        Book book = new Book("Wonder", "R.J. Palacio", 2012);
        book.book();

        book.unbook();

        assertEquals(false, book.isBooked());
    }

    @Test
    public void shouldReturnTheBookDetails() {
        Book book = new Book("Wonder", "R.J. Palacio", 2012);

        String bookDetails = book.getDetails();

        assertEquals("Wonder - R.J. Palacio - 2012", bookDetails);
    }
}