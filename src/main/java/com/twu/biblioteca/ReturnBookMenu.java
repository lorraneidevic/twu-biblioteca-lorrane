package com.twu.biblioteca;

import java.util.Scanner;

public class ReturnBookMenu implements Option {

    private BookController bookController;

    public ReturnBookMenu(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void print() {
        bookController.printUnavailableBooks();

        int bookId = getBookId();

        try {
            returnBook(bookId);
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getName() {
        System.out.println("3 - Return a Book");
    }

    private int getBookId(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nType the ID (integer) of the book you wanna checkout:");

        return scanner.nextInt();
    }

    private void returnBook(int bookId) throws BookReservationException, IndexOutOfBoundsException{
        Book bookReturned = bookController.listBooks().get(bookId - 1);

        try {
            bookController.returnBook(bookReturned);
            System.out.println("\nThank you for returning the book");
        } catch (BookReservationException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
