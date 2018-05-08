package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckoutMenu implements Option {
    private BookController bookController;

    public CheckoutMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print(){
        bookController.printAvailableBooks();

        int bookId = getBookId();

        try {
            checkoutBook(bookId);
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private int getBookId(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nType the ID (integer) of the book you wanna checkout:");

        return scanner.nextInt();
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



    @Override
    public void getName() {
        System.out.println("2 - Checkout BookController");
    }
}
