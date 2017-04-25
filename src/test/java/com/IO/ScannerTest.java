package com.IO;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kram on 25.04.17.
 */
public class ScannerTest {

    private Scanner scanner;

    @Before
    public void setUp() {
        scanner = new Scanner();
    }

    @Test
    public void testScanEmpty(){
        String empty = "";
        String result = scanner.scan(empty);
        assertEquals(result,"Invalid bar-code");
    }

    @Test
    public void testScan(){
        String barcode = "12345";
        String result = scanner.scan(barcode);
        assertEquals(result,barcode);
    }

}
