package com.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kram on 25.04.17.
 */
public class ReceiptTest {

    private Receipt receipt;

    @Before
    public void setUp(){
        receipt = new Receipt();
    }

    @Test
    public void testAddProduct(){
        receipt = new Receipt();
        Product testProduct1 = new Product("Product1","12345",99.99);
        receipt.addProduct(testProduct1);
        assertTrue(receipt.getProductList().contains(testProduct1));
        Product testProduct2 = new Product("Product2","123456",50.00);
        receipt.addProduct(testProduct2);
        assertTrue(receipt.getProductList().contains(testProduct2));
        assertEquals(receipt.getTotal(),149.99,0);
    }

}
