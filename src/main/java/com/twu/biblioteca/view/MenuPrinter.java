package com.twu.biblioteca.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuPrinter {
    List<Option> listOptions;

    public MenuPrinter(List<Option> listOptions) {
        this.listOptions = listOptions;
        this.listOptions.add(new QuitMenu());
    }

    public void showMenu() {
        System.out.println("Please choose one of the options in the menu below by typing its number:");
        for (int i = 0; i < listOptions.size(); i++) {
            System.out.println( (i +1) + " - " +listOptions.get(i).getName());
        }

        chooseMenu();
    }

    private void chooseMenu() {
        int menuOption = getScannerNextIntAndValidateIfIsValid();

        listOptions.get(menuOption-1).print();

        System.out.println("\n");
        if(menuOption != listOptions.size()) {
            showMenu();
        }
    }

    public int getScannerNextIntAndValidateIfIsValid() {
        Scanner scanner = new Scanner(System.in);

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
