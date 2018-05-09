package com.twu.biblioteca.view;

public class QuitMenu implements Option {
    @Override
    public void print() {
        System.out.println("\nQuitting the app...");
//        System.exit(0);
        //end loop
    }

    @Override
    public String getName() {
        return "Quit";
    }
}
