package com.twu.biblioteca;

import com.twu.biblioteca.domain.book.BookController;
import com.twu.biblioteca.view.*;

import java.util.ArrayList;

public class BibliotecaApp {

    private static MenuPrinter menuPrinter;

    public static void main(String[] args) {
        System.out.println("\n------------------ Welcome to Biblioteca - Bangalore Public Library ------------------");//menu printer

        BookController bookController = new BookController();
        ArrayList<Option> menus = new ArrayList<Option>();

        menus.add(new ListBooksMenu(bookController));
        menus.add(new CheckoutMenu(bookController));
        menus.add(new ReturnBookMenu(bookController));

        menuPrinter = new MenuPrinter(menus);

        menuPrinter.showMenu();
    }


}
