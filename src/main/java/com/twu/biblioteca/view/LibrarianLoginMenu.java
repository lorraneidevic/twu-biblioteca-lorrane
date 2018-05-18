package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.auth.Auth;
import com.twu.biblioteca.domain.book.BookController;
import com.twu.biblioteca.domain.movie.MovieController;
import com.twu.biblioteca.domain.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianLoginMenu implements Option {
    Auth auth;
    BookController bookController;
    MovieController movieController;

    public LibrarianLoginMenu(Auth auth, MovieController movieController, BookController bookController) {
        this.auth = auth;
        this.movieController = movieController;
        this.bookController = bookController;
    }

    @Override
    public void print() {
        User user = getUserCredentials();

        if(validateLogin(user)) {
            showMenu();
        } else {
            print();
        }
    }

    private User getUserCredentials() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type your Librarian Number (xxx-xxxx): ");
        String librarianNumber = scanner.nextLine();

        System.out.println("Please type your password: ");
        String password = scanner.nextLine();

        return new User().createLibrarian(librarianNumber, password);
    }

    public boolean validateLogin(User user) {//mudar para boolean e corrigir teste
        if(auth.canUserLogin(user)) {
            System.out.println("You're logged in!");
            return true;
        } else {
            System.out.println("Librarian Number or Password incorrect.");
            return false;
        }
    }

    @Override
    public String getName() {
        return "Librarian Login";
    }

    private void showMenu() {

        MenuPrinter menuPrinter;

        ArrayList<Option> menus = new ArrayList<>();

        menus.add(new ListBooksMenu(bookController));
        menus.add(new CheckoutMenu(bookController));
        menus.add(new WhoCheckedOutABookMenu(bookController));
        menus.add(new ReturnBookMenu(bookController));
        menus.add(new ListMoviesMenu(movieController));
        menus.add(new CheckoutMovieMenu(movieController));

        menuPrinter = new MenuPrinter(menus);

        menuPrinter.showMenu();
    }
}
