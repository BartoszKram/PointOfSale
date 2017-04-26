package com.IO;


import com.Controller;
import com.Database;
import com.Model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by kram on 25.04.17.
 */
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
        assertEquals(result,"Invalid bar-code");
    }

    @Test
    public void testScanExit(){
        assertEquals(scanner.scan("exit"),"exit");
    }

    @Test
    public void testScan(){
        String barcode = "12345";
        String result = scanner.scan(barcode);
        assertEquals(result,barcode);
    }

}
