package com.twu.biblioteca;

public class QuitMenu implements Option {
    @Override
    public void print() {
        System.out.println("\nQuitting the app...");
//        System.exit(0);
        //end loop
    }

    @Override
    public void getName() {
        System.out.println("4 - Quit");
    }
}
