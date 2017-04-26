package com.service;

import com.IO.LCDdisplay;
import com.IO.Printer;
import com.IO.Scanner;
import com.model.Product;
import com.model.Receipt;
import com.service.Controller;
import com.database.Database;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    private Controller controller;
    private LCDdisplay lcDdisplay;
    private Scanner scanner;
    private Printer printer;
    private Database database;
    private Receipt receipt;

    @Before
    public void setUp(){
        lcDdisplay = mock(LCDdisplay.class);
        scanner = mock(Scanner.class);
        printer = mock(Printer.class);
        database = mock(Database.class);
        receipt = mock(Receipt.class);
        controller = new Controller(lcDdisplay,scanner,printer,database,receipt);
        when(scanner.scan("")).thenReturn("Invalid bar-code");
        when(scanner.scan("exit")).thenReturn("exit");
        when(scanner.scan("12345")).thenReturn("12345");
        when(database.findProduct(anyString())).thenReturn(null);
        when(database.findProduct("12345")).thenReturn(new Product("testProduct","12345",99.99));
    }

    @Test
    public void testExit(){
        controller.exit();
        verify(lcDdisplay,times(1)).displayTotal(anyDouble());
        verify(printer,times(1)).displayReceipt(any(Receipt.class));
    }

    @Test
    public void testInvalidProduct(){
        controller.invalidProduct();
        verify(lcDdisplay,times(1)).displayInfo("Invalid bar-code");
    }

    @Test
    public void testProductNotFound(){
     controller.productNotFound();
     verify(lcDdisplay,times(1)).displayInfo("Product not found");
    }

    @Test
    public void testProductFound(){
        Product testProduct = new Product("TestProduct", "12345",99.99);
        controller.productFound(testProduct);
        verify(lcDdisplay).displayProduct(any(Product.class));
        verify(receipt).addProduct(any(Product.class));
    }

    @Test
    public void testServiceEmpty(){
        controller.service("");
        verify(scanner,atLeastOnce()).scan("");
    }

    @Test
    public void testExitBarcode() throws Exception{
        controller.service("exit");
        verify(scanner).scan("exit");
    }

    @Test
    public void testDatabaseBarcode(){
        controller.service("12345");
        verify(scanner,atLeastOnce()).scan("12345");
        verify(database).findProduct("12345");
    }

}