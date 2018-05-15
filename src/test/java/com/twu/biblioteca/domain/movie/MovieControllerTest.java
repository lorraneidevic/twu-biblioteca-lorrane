package com.twu.biblioteca.domain.movie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieControllerTest {
    private MovieController movieController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        movieController = new MovieController();
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void listMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Wonder Woman", 2017, "Patty Jenkins", 9));
        movies.add(new Movie("The Greatest Showman", 2017, "Michael Gracey", 7));
        movies.add(new Movie("Tomb Raider", 2018, "Roar Uthaug", 8));
        movies.add(new Movie("Wonder", 2017, "Stephen Chbosky", 10));

        ArrayList<Movie> testMovies = movieController.listMovies();

        assertEquals(movies.size(), testMovies.size());
        assertEquals(movies.get(0).getName(), testMovies.get(0).getName());
    }

    @Test
    public void listAvailableMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Wonder Woman", 2017, "Patty Jenkins", 9));

        ArrayList<Movie> testMovies = movieController.listAvailableMovies();

        assertEquals(movies.get(0).getName(), testMovies.get(0).getName());
    }

    @Test
    public void listUnavailableMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Wonder Woman", 2017, "Patty Jenkins", 9));

        ArrayList<Movie> testMovies = movieController.listUnavailableMovies();

        assertNotSame(movies.size(), testMovies.size());
    }

    @Test
    public void checkoutMovie() {
        Movie movie = movieController.listMovies().get(0);

        try {
            movieController.checkoutMovie(movie);

            ArrayList<Movie> unavailableMovies = movieController.listUnavailableMovies();

            assertEquals(movie.getName(), unavailableMovies.get(0).getName());
        } catch (MovieReservationException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void returnMovie() {
        Movie movie = movieController.listMovies().get(0);

        try {
            movieController.returnMovie(movie);

            fail("Should throw an exception here since there isn't a movie available");
        } catch (MovieReservationException ex) {
            assertEquals("That movie is not available", ex.getMessage());
        }
    }
}