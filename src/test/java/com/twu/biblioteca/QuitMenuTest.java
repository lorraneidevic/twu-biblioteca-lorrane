package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.contains;

public class QuitMenuTest {

    private QuitMenu quitMenu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

        quitMenu = new QuitMenu();
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void print() {
        //action
        quitMenu.print();

        //assert
        assertThat(outContent.toString(), containsString("Quitting the app..."));
    }

    @Test
    public void getName() {
        //action
        quitMenu.getName();

        //assert
        assertThat(outContent.toString(), containsString("4 - Quit"));
    }
}