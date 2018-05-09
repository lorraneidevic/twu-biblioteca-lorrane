package com.twu.biblioteca.domain.movie;

import com.twu.biblioteca.domain.book.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnTheMovieName() {
        Movie movie = new Movie("Wonder Woman", 2017, "Patty Jenkins", 9);

        String movieName = movie.getName();

        assertEquals("Wonder Woman", movieName);
    }

    @Test
    public void shouldBookAMovie() {
        Movie movie = new Movie("Wonder Woman", 2017, "Patty Jenkins", 9);

        movie.book();

        assertEquals(true, movie.isBooked());
    }

    @Test
    public void shouldUnbookAMovie() {
        Movie movie = new Movie("Wonder Woman", 2017, "Patty Jenkins", 9);

        movie.book();
        movie.unbook();

        assertEquals(false, movie.isBooked());
    }
}