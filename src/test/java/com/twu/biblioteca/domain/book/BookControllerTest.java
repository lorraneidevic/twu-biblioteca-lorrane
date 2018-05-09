package com.twu.biblioteca.domain.book;

import com.twu.biblioteca.domain.book.Book;
import com.twu.biblioteca.domain.book.BookController;
import com.twu.biblioteca.domain.book.BookReservationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BookControllerTest {
    private BookController bookControllerTestClass;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        bookControllerTestClass = new BookController();
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnAListOfBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("TDD", "Kent Beck", 2000));
        books.add(new Book("Clean Code", "Robert Cecil Martin", 2008));
        books.add(new Book("Simon vs. the Homo Sapiens Agenda", "Becky Albertalli", 2015));
        books.add(new Book("Wonder", "R.J. Palacio", 2012));

        ArrayList<Book> testBooks = bookControllerTestClass.listBooks();

        assertEquals(books.size(), testBooks.size());
        assertEquals(books.get(0).getDetails(), testBooks.get(0).getDetails());
        assertEquals(books.get(1).getDetails(), testBooks.get(1).getDetails());
        assertEquals(books.get(2).getDetails(), testBooks.get(2).getDetails());
        assertEquals(books.get(3).getDetails(), testBooks.get(3).getDetails());
    }

    @Test
    public void shouldReturnAListOfAvailableBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("TDD", "Kent Beck", 2000));
        books.add(new Book("Clean Code", "Robert Cecil Martin", 2008));
        books.add(new Book("Simon vs. the Homo Sapiens Agenda", "Becky Albertalli", 2015));
        books.add(new Book("Wonder", "R.J. Palacio", 2012));

        ArrayList<Book> availableBooks = bookControllerTestClass.listAvailableBooks();

        assertEquals(books.size(), availableBooks.size());
        assertEquals(books.get(0).getDetails(), availableBooks.get(0).getDetails());
        assertEquals(books.get(1).getDetails(), availableBooks.get(1).getDetails());
        assertEquals(books.get(2).getDetails(), availableBooks.get(2).getDetails());
        assertEquals(books.get(3).getDetails(), availableBooks.get(3).getDetails());

    }

    @Test
    public void shouldCheckoutABook(){
        Book book = bookControllerTestClass.listBooks().get(2);

        try {
            bookControllerTestClass.checkoutBook(book);

            assertEquals(true, bookControllerTestClass.listBooks().get(2).isBooked());
        } catch (BookReservationException expectedException) {
            fail( "This method shouldn't throw a exception here." );
        }
    }

    @Test
    public void shouldNotCheckoutABookedBook(){
        Book book = bookControllerTestClass.listBooks().get(2);

        bookControllerTestClass.listBooks().get(2).book();

        try {
            bookControllerTestClass.checkoutBook(book);
            fail( "A exception was expected here since we are trying to checkout a book already booked." );
        } catch (BookReservationException expectedException) {
            assertEquals(true, bookControllerTestClass.listBooks().get(2).isBooked());
        }

    }

    @Test
    public void shouldReturnToTheLibraryABookedBook() {
        Book book = bookControllerTestClass.listBooks().get(2);

        try {
            bookControllerTestClass.checkoutBook(book);
            assertEquals(true, bookControllerTestClass.listBooks().get(2).isBooked());


            bookControllerTestClass.returnBook(book);

            assertEquals(false, bookControllerTestClass.listBooks().get(2).isBooked());
        } catch (BookReservationException expectedException) {
            fail( "This method shouldn't throw a exception here." );
        }
    }

    @Test
    public void shouldReturnToTheLibraryANotBookedBook() {
        Book book = bookControllerTestClass.listBooks().get(2);

        try {
            bookControllerTestClass.returnBook(book);

            fail( "A exception was expected here since we are trying to return a book not booked." );
        } catch (BookReservationException expectedException) {
            assertEquals(false, bookControllerTestClass.listBooks().get(2).isBooked());
        }
    }
}
