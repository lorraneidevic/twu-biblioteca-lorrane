package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BookControllerTest {
    private BookController bookControllerTestClass;

    @Before
    public void setUp() throws Exception{
        bookControllerTestClass = new BookController();
    }

    @Test
    public void shouldReturnAListOfBooks(){
        //arrange
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("TDD", "Kent Beck", 2000));
        books.add(new Book("Clean Code", "Robert Cecil Martin", 2008));
        books.add(new Book("Simon vs. the Homo Sapiens Agenda", "Becky Albertalli", 2015));
        books.add(new Book("Wonder", "R.J. Palacio", 2012));

        //action
        ArrayList<Book> testBooks = bookControllerTestClass.listBooks();

        //asserts
        assertEquals(books.size(), testBooks.size());
        assertEquals(books.get(0).getDetails(), testBooks.get(0).getDetails());
        assertEquals(books.get(1).getDetails(), testBooks.get(1).getDetails());
        assertEquals(books.get(2).getDetails(), testBooks.get(2).getDetails());
        assertEquals(books.get(3).getDetails(), testBooks.get(3).getDetails());
    }

    @Test
    public void shouldCheckoutABook(){
        //arrange
        Book book = bookControllerTestClass.books.get(2);

        try {
            //action
            bookControllerTestClass.checkoutBook(book);

            //assert
            assertEquals(true, bookControllerTestClass.books.get(2).isBooked());
        } catch (BookReservationException expectedException) {
            fail( "This method shouldn't throw a exception here." );
        }
    }

    @Test
    public void shouldNotCheckoutABookedBook(){
        //arrange
        Book book = bookControllerTestClass.books.get(2);

        //action
        bookControllerTestClass.books.get(2).book();

        try {
            bookControllerTestClass.checkoutBook(book);
            fail( "A exception was expected here since we are trying to checkout a book already booked." );
        } catch (BookReservationException expectedException) {
            assertEquals(true, bookControllerTestClass.books.get(2).isBooked());
        }

    }

    @Test
    public void shouldReturnToTheLibraryABookedBook() {
        //arrange
        Book book = bookControllerTestClass.books.get(2);

        //action
        try {
            bookControllerTestClass.checkoutBook(book);
            assertEquals(true, bookControllerTestClass.books.get(2).isBooked());


            bookControllerTestClass.returnBook(book);

            //assert
            assertEquals(false, bookControllerTestClass.books.get(2).isBooked());
        } catch (BookReservationException expectedException) {
            fail( "This method shouldn't throw a exception here." );
        }
    }

    @Test
    public void shouldReturnToTheLibraryANotBookedBook() {
        //arrange
        Book book = bookControllerTestClass.books.get(2);

        //action
        try {
            bookControllerTestClass.returnBook(book);

            //assert
            fail( "A exception was expected here since we are trying to return a book not booked." );
        } catch (BookReservationException expectedException) {
            assertEquals(false, bookControllerTestClass.books.get(2).isBooked());
        }
    }
}
