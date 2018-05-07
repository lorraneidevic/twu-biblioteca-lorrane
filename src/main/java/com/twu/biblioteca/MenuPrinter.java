package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class MenuPrinter {
    List<Option> listOptions;

    public MenuPrinter(List<Option> listOptions) {
        this.listOptions = listOptions;
    }

    public void showMenu() {
        System.out.println("\n\nPlease choose one of the options in the menu below by typing its number:");
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout BookController");
        System.out.println("3 - Return BookController");
        System.out.println("4 - Quit");
    }

    public void chooseMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuOption = scanner.nextInt();

        listOptions.get(menuOption-1).print();
    }
}
