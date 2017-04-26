package com.IO;


import com.service.Controller;
import com.database.Database;
import com.model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ScannerTest {

    private Scanner scanner;
    private Controller controller;
    private Database database;

    @Before
    public void setUp() {
        controller = mock(Controller.class);
        database = mock(Database.class);
        scanner = new Scanner();
        when(database.findProduct("123456")).thenReturn(new Product("testProduct1","123456",99.99));
        when(database.findProduct("12345")).thenReturn(new Product("testProduct2","12345",49.99));
    }

    @Test
    public void testScanEmpty(){
        String empty = "";
        String result = scanner.scan(empty);
        assertEquals("Invalid bar-code", result);
    }

    @Test
    public void testScanExit(){
        assertEquals("exit",scanner.scan("exit"));
    }

    @Test
    public void testScan(){
        String barcode = "12345";
        String result = scanner.scan(barcode);
        assertEquals(barcode,result);
    }

}
