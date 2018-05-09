package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.BookController;
import com.twu.biblioteca.domain.BookReservationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckoutMenu implements Option {
    private BookController bookController;

    public CheckoutMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print(){
        printAvailableBooks();

        if(hasAvailableBooks()) {
            int bookId = getScannerNextIntAndValidateIfIsValid();

            try {
                checkoutBook(bookId);
            } catch (BookReservationException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private int getScannerNextIntAndValidateIfIsValid() {
        Scanner scanner = new Scanner(System.in);

        int value = 0;
        boolean loop = true;

        while (loop) {
            try {
                System.out.println("\nType the ID (integer) of the book you wanna checkout:");
                value = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException ex) {
                System.out.println("\nType a valid value!");
                scanner.next();
            }
        }

        return value;

    }

    private void checkoutBook(int bookId) throws BookReservationException, IndexOutOfBoundsException{
        Book bookCheckedOut = bookController.listBooks().get(bookId - 1);

        try {
            bookController.checkoutBook(bookCheckedOut);
            System.out.println("\nThank you! Enjoy the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printAvailableBooks() {
        ArrayList<Book> books = bookController.listBooks();

        if(hasAvailableBooks()) {
            System.out.println("\nAvailable books to checkout:");
            for (int i = 0; i < books.size(); i++) {
                if(!books.get(i).isBooked()) {
                    System.out.println((i + 1) + " - " + books.get(i).getName());
                }
            }
        } else {
            System.out.println("\nThere is no book left to checkout.");
        }
    }

    private boolean hasAvailableBooks(){
        return bookController.listAvailableBooks().size() > 0;
    }

    @Override
    public String getName() {
        return "Checkout a Book";
    }
}
