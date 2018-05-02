package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("\n------------------ Welcome to Biblioteca - Bangalore Public Library ------------------");

        ShowMenu();
    }

    private static void ShowMenu(){
        System.out.println("\nPlease choose one of the options in the menu below by typing its number:");
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout Book");
        System.out.println("3 - Return Book");
        System.out.println("4 - Quit");
    }
}
