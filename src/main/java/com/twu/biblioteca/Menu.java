package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.BookController;
import com.twu.biblioteca.domain.BookReservationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    BookController bookController;
    Scanner scanner = new Scanner(System.in);

    public Menu(){
        bookController = new BookController();
    }

    public void showMenu(){
        System.out.println("\n\nPlease choose one of the options in the menu below by typing its number:");
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout a Book");
        System.out.println("3 - Return a Book");
        System.out.println("4 - Quit");

        ChooseMenuOption();
    }

    public void ChooseMenuOption() {
        int menuOption = getScannerNextIntAndValidateIfIsValid();

        switch (menuOption) {
            case 1: {
                printAvailableBooks();
                showMenu();
                break;
            }

            case 2: {
                checkoutBook();
                showMenu();
                break;
            }

            case 3: {
                returnBook();
                showMenu();
                break;
            }

            case 4: {
                quitApp();
                break;
            }

            default: {
                System.out.println("\nSelect a valid option!");
                showMenu();
                break;
            }
        }
    }

    public void printAvailableBooks(){
        ArrayList<Book> books = bookController.listBooks();
        int returnedBooks = 0;

        System.out.println();

        for (int i = 0; i<books.size(); i++) {
            if(!books.get(i).isBooked()) {
                System.out.println((i + 1) + " - " + books.get(i).getDetails());
                returnedBooks++;
            }
        }

        if(returnedBooks == 0) {
            System.out.println("\nThere is no book left to checkout.");
        }
    }

    public void printCheckedOutBooks(){
        ArrayList<Book> books = bookController.listBooks();
        int checkedOutBooks = 0;

        System.out.println();

        for (int i = 0; i<books.size(); i++) {
            if(books.get(i).isBooked()) {
                System.out.println((i + 1) + " - " + books.get(i).getDetails());
                checkedOutBooks++;
            }
        }

        if(checkedOutBooks == 0) {
            System.out.println("\nThere is no book left to return.");
        }
    }

    public void checkoutBook(){
        printAvailableBooks();
        System.out.println("\n\nType the ID (integer) of the book you wanna checkout:");
        int bookId = getScannerNextIntAndValidateIfIsValid();

        Book bookCheckedOut = bookController.listBooks().get(bookId - 1);

        try {
            bookController.checkoutBook(bookCheckedOut);
            System.out.println("\nThank you! Enjoy the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void returnBook(){
        printCheckedOutBooks();
        System.out.println("\n\nType the ID (integer) of the book you wanna return:");
        int bookId = getScannerNextIntAndValidateIfIsValid();

        Book returnedBook = bookController.listBooks().get(bookId - 1);

        try {
            bookController.returnBook(returnedBook);
            System.out.println("\nThank you for returning the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void quitApp() {
        System.out.println("\nQuitting the app...");
        System.exit(0);
    }

    public int getScannerNextIntAndValidateIfIsValid() {
        int value = 0;
        boolean loop = true;

        while (loop) {
            try {
                value = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException ex) {
                System.out.println("\nType a valid value!");
                scanner.next();
            }
        }

        return value;
    }
}
