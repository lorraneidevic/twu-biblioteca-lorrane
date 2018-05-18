package com.twu.biblioteca;

import com.twu.biblioteca.domain.auth.Auth;
import com.twu.biblioteca.domain.book.BookController;
import com.twu.biblioteca.domain.movie.MovieController;
import com.twu.biblioteca.view.*;

import java.util.ArrayList;

public class BibliotecaApp {

    private static MenuPrinter menuPrinter;

    public static void main(String[] args) {
        System.out.println("\n------------------ Welcome to Biblioteca - Bangalore Public Library ------------------");//menu printer

        Auth auth = new Auth();
        MovieController movieController = new MovieController();
        BookController bookController = new BookController();

        ArrayList<Option> loginMenus = new ArrayList<>();


        loginMenus.add(new CustomerLoginMenu(auth, movieController, bookController));
        loginMenus.add(new LibrarianLoginMenu(auth, movieController, bookController));

        menuPrinter = new MenuPrinter(loginMenus);

        menuPrinter.showMenu();

//        ArrayList<Option> menus = new ArrayList<Option>();
//
//        menus.add(new ListBooksMenu(bookController));
//        menus.add(new CheckoutMenu(bookController));
//        menus.add(new ReturnBookMenu(bookController));
//
//        menuPrinter = new MenuPrinter(menus);
//
//        menuPrinter.showMenu();
    }


}
