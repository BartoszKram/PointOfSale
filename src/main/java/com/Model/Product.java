package com.Model;

/**
 * Created by kram on 25.04.17.
 */
public class Product {

    private String name;
    private String barcode;
    private double price;

    public Product(String name, String barcode, double price){
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
