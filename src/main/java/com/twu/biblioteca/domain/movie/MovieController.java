package com.twu.biblioteca.domain.movie;

import java.util.ArrayList;

public class MovieController {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieController() {
        movies.add(new Movie("Wonder Woman", 2017, "Patty Jenkins", 9));
        movies.add(new Movie("The Greatest Showman", 2017, "Michael Gracey", 0));
        movies.add(new Movie("Tomb Raider", 2018, "Roar Uthaug", 8));
        movies.add(new Movie("Wonder", 2017, "Stephen Chbosky", 10));
    }

    public ArrayList<Movie> listMovies(){
        return movies;
    }

    public ArrayList<Movie> listAvailableMovies() {
        ArrayList<Movie> availableMovies = new ArrayList<>();
        ArrayList<Movie> allMovies = listMovies();

        for(int i = 0; i < allMovies.size(); i++) {
            if (!allMovies.get(i).isBooked()){
                availableMovies.add(allMovies.get(i));
            }
        }

        return availableMovies;
    }

    public ArrayList<Movie> listUnavailableMovies() {
        ArrayList<Movie> unavailableMovies = new ArrayList<>();
        ArrayList<Movie> allMovies = listMovies();

        for(int i = 0; i < allMovies.size(); i++) {
            if (allMovies.get(i).isBooked()){
                unavailableMovies.add(allMovies.get(i));
            }
        }

        return unavailableMovies;
    }

    public void checkoutMovie(Movie movie) throws MovieReservationException{
        int index = movies.indexOf(movie);

        if(movies.get(index).isBooked()){
            throw new MovieReservationException("That movie is not available");
        } else {
            movies.get(index).book();
        }
    }

    public void returnMovie(Movie movie) throws MovieReservationException{
        int index = movies.indexOf(movie);

        if(movies.get(index).isBooked()){
            movies.get(index).unbook();
        } else {
            throw new MovieReservationException("That movie is not available");
        }
    }
}
