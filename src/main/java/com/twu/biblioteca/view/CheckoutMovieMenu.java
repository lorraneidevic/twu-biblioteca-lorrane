package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.movie.Movie;
import com.twu.biblioteca.domain.movie.MovieController;
import com.twu.biblioteca.domain.movie.MovieReservationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckoutMovieMenu implements Option {
    private MovieController movieController;

    public CheckoutMovieMenu(MovieController movieController) {
        this.movieController = movieController;
    }

    @Override
    public void print() {
        printAvailableMovies();

        if(hasAvailableMovies()) {
            int movieId = getScannerNextIntAndValidateIfIsValid();

            checkoutMovie(movieId);
        }
    }

    @Override
    public String getName() {
        return "Checkout a Movie";
    }

    public void printAvailableMovies() {
        ArrayList<Movie> movies = movieController.listMovies();

        if(hasAvailableMovies()) {
            System.out.println("\nAvailable movies:");
            for (int i = 0; i < movies.size(); i++) {
                if(!movies.get(i).isBooked()) {
                    System.out.println((i + 1) + " - " + movies.get(i).getName());
                }
            }
        } else {
            System.out.println("\nThere is no movie left to checkout.");
        }
    }

    private boolean hasAvailableMovies(){
        return movieController.listAvailableMovies().size() > 0;
    }

    private int getScannerNextIntAndValidateIfIsValid() {
        Scanner scanner = new Scanner(System.in);

        int value = 0;
        boolean loop = true;

        while (loop) {
            try {
                System.out.println("\nType the ID (integer) of the movie you wanna checkout:");
                value = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException ex) {
                System.out.println("\nType a valid value!");
                scanner.next();
            }
        }

        return value;

    }

    private void checkoutMovie(int movieId) throws IndexOutOfBoundsException{
        try {
            Movie movieCheckedOut = movieController.listMovies().get(movieId - 1);
            movieController.checkoutMovie(movieCheckedOut);
            System.out.println("\nThank you! Enjoy the movie");
        } catch (MovieReservationException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("That is not a valid movie to return");
        }
    }
}
