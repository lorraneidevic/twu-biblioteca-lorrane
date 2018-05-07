package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListBooksMenuTest {
    ListBooksMenu listBooksMenu;

    @Before
    public void setUp() throws Exception {
        listBooksMenu = new ListBooksMenu();
    }

    @Test
    public void print() {
        listBooksMenu.print();


    }

    @Test
    public void getName() {
    }
}