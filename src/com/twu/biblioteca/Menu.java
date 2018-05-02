package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        System.out.println("2 - Checkout BookController");
        System.out.println("3 - Return BookController");
        System.out.println("4 - Quit");

        ChooseMenuOption();
    }

    public void ChooseMenuOption() {
        int menuOption = scanner.nextInt();

        switch (menuOption) {
            case 1: {
                printBooks();
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
                System.out.println("\nQuitting the app...");
                System.exit(0);
            }

            default: {
                System.out.println("\nSelect a valid option!");
                showMenu();
                break;
            }
        }
    }

    public void printBooks(){
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

    public void printCheckedoutBooks(){
        ArrayList<Book> books = bookController.listBooks();
        int checkedoutBooks = 0;

        System.out.println();

        for (int i = 0; i<books.size(); i++) {
            if(books.get(i).isBooked()) {
                System.out.println((i + 1) + " - " + books.get(i).getDetails());
                checkedoutBooks++;
            }
        }

        if(checkedoutBooks == 0) {
            System.out.println("\nThere is no book left to return.");
        }
    }

    public void checkoutBook(){
        printBooks();
        System.out.println("\n\nType the ID (integer) of the book you wanna checkout:");
        int bookId = scanner.nextInt() - 1;

        Book bookCheckedOut = bookController.listBooks().get(bookId);

        try {
            bookController.checkoutBook(bookCheckedOut);
            System.out.println("\nThank you! Enjoy the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void returnBook(){
        printCheckedoutBooks();
        System.out.println("\n\nType the ID (integer) of the book you wanna return:");
        int bookId = scanner.nextInt() - 1;

        Book returnedBook = bookController.listBooks().get(bookId);

        try {
            bookController.returnBook(returnedBook);
            System.out.println("\nThank you for returning the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
