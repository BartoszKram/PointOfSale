package com.database;

import com.model.Product;

import java.util.ArrayList;

public class Database {

    private ArrayList<Product> productDatabase;

    public Database(){
        this.productDatabase=new ArrayList<Product>();
    }

    public void addProductToDatabase(Product product){
        this.productDatabase.add(product);
    }

    public Product findProduct(String barcode){
        for (Product aProductDatabase : productDatabase) {
            if (aProductDatabase.getBarcode().equals(barcode)) {
                return aProductDatabase;
            }
        }
        return null;
    }

    public ArrayList<Product> getProductDatabase() {
        return productDatabase;
    }
}
