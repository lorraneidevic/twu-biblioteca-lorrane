package com.twu.biblioteca.view;

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
import static org.mockito.Mockito.when;

public class MenuPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private MenuPrinter menuPrinter;
    private Option option;
    List<Option> listOptions;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        option = mock(Option.class);
        when(option.getName()).thenReturn("Option 1");

        listOptions = new ArrayList(Arrays.asList(option));
        menuPrinter = new MenuPrinter(listOptions);
    }

    @After
    public void tearDown() {
        outContent.reset();
        System.setOut(System.out);
    }

    @Test
    public void showMenu() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menuPrinter.showMenu();

        assertThat(outContent.toString(),containsString("Option 1"));
    }
}