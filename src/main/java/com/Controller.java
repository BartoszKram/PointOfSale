package com;

import com.IO.LCDdisplay;
import com.IO.Printer;
import com.IO.Scanner;
import com.Model.Product;
import com.Model.Receipt;

/**
 * Created by kram on 25.04.17.
 */
public class Controller implements iController{

    private LCDdisplay display;
    private Scanner scanner;
    private Printer printer;
    private Database database;
    private Receipt receipt;

    public Controller(LCDdisplay disp, Scanner scan, Printer prnt, Database data, Receipt recpt){
        display = disp;
        scanner = scan;
        printer = prnt;
        database = data;
        receipt = recpt;
    }

    public void exit(){
        display.displayTotal(receipt.getTotal());
        printer.displayReceipt(receipt);
    }

    public void invalidProduct() {
        display.displayInfo("Invalid bar-code");
    }

    public void productNotFound() {
        display.displayInfo("Product not found");
    }

    public void productFound(Product product) {
        display.displayProduct(product);
        receipt.addProduct(product);
    }

    public void service(String barcode) {
        if(scanner.scan(barcode).equals("exit")){
            exit();
        }
        else {
            if (!scanner.scan(barcode).equals("Invalid bar-code")) {
                Product product = database.findProduct(scanner.scan(barcode));
                if (!product.equals(null)) {
                    productFound(product);
                } else {
                    productNotFound();
                }
            } else {
                invalidProduct();
            }
        }
    }
}
