package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private MenuPrinter menuPrinter;
    private Option option;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));

        option = mock(Option.class); //cria uma opcao qualquer de menu
        List<Option> listOptions = Arrays.asList(option); //inicializa lista de options
        menuPrinter = new MenuPrinter(listOptions); //inicializa menuPrinter com lista de options
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void showMenu() {

        //action
        menuPrinter.showMenu();

        //assert
        assertThat(outContent.toString(),containsString("Please choose one of the options in the menu below by typing its number:"));
        assertThat(outContent.toString(),containsString("1 - List Books"));
        assertThat(outContent.toString(),containsString("2 - Checkout BookController"));
        assertThat(outContent.toString(),containsString("3 - Return BookController"));
        assertThat(outContent.toString(),containsString("4 - Quit"));
    }

    @Test
    public void chooseMenu() {
        //arrange
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //action
        menuPrinter.chooseMenu();

        //assert
        verify(option).print();
    }
}