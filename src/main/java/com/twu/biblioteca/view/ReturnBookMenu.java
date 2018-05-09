package com.twu.biblioteca.view;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.BookController;
import com.twu.biblioteca.domain.BookReservationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReturnBookMenu implements Option {

    private BookController bookController;

    public ReturnBookMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print() {
        printUnavailableBooks();

        if(hasUnvailableBooks()) {
            int bookId = getScannerNextIntAndValidateIfIsValid();

            try {
                returnBook(bookId);
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
                System.out.println("\nType the ID (integer) of the book you wanna return:");
                value = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException ex) {
                System.out.println("\nType a valid value!");
                scanner.next();
            }
        }

        return value;

    }

    private void returnBook(int bookId) throws BookReservationException, IndexOutOfBoundsException{
        try {
            Book bookReturned = bookController.listBooks().get(bookId - 1);
            bookController.returnBook(bookReturned);
            System.out.println("\nThank you for returning the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("That is not a valid book to return");
        }
    }

    public void printUnavailableBooks() {
        ArrayList<Book> books = bookController.listBooks();

        if(hasUnvailableBooks()) {
            System.out.println("\nAvailable books to return:");
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).isBooked()) {
                    System.out.println((i + 1) + " - " + books.get(i).getName());
                }
            }
        } else {
            System.out.println("\nThere is no book left to return.");
        }
    }

    private boolean hasUnvailableBooks(){
        return bookController.listUnavailableBooks().size() > 0;
    }

    @Override
    public String getName() {
        return "Return a Book";
    }
}
