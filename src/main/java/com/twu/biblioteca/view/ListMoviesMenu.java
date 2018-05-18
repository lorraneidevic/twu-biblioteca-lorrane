package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.movie.Movie;
import com.twu.biblioteca.domain.movie.MovieController;

import java.util.ArrayList;

public class ListMoviesMenu implements Option {
    private MovieController movieController;

    public ListMoviesMenu(MovieController movieController) {
        this.movieController = movieController;
    }

    @Override
    public void print() {
        printAvailableBooks();
    }

    public void printAvailableBooks() {
        ArrayList<Movie> movies = movieController.listMovies();

        if(hasAvailableBooks()) {
            System.out.println("\nAvailable movies:");
            for (int i = 0; i < movies.size(); i++) {
                if(!movies.get(i).isBooked()) {
                    System.out.println((i + 1) + " - " + movies.get(i).getDetails());
                }
            }
        } else {
            System.out.println("\nThere is no movie left to checkout.");
        }
    }

    private boolean hasAvailableBooks(){
        return movieController.listAvailableMovies().size() > 0;
    }

    @Override
    public String getName() {
        return "List Movies";
    }
}
