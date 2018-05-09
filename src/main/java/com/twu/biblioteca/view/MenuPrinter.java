package com.twu.biblioteca.view;

import java.util.List;
import java.util.Scanner;

public class MenuPrinter {
    List<Option> listOptions;
    Scanner scanner;

    public MenuPrinter(List<Option> listOptions) {
        this.listOptions = listOptions;
        this.listOptions.add(new QuitMenu());

        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("Please choose one of the options in the menu below by typing its number:");
        for (int i = 0; i < listOptions.size(); i++) {
            System.out.println( (i +1) + " - " +listOptions.get(i).getName());
        }

        chooseMenu();
    }

    private void chooseMenu() {
        Scanner s = new Scanner(System.in);

        int menuOption = s.nextInt();

        listOptions.get(menuOption-1).print();

        System.out.println("\n\n");
        if(menuOption != listOptions.size()) {
            showMenu();
        }
    }
}
