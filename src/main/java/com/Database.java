package com;

import com.Model.Product;

import java.util.ArrayList;

/**
 * Created by kram on 25.04.17.
 */
public class Database {

    private ArrayList<Product> productDatabase;

    public void Database(){
        this.productDatabase=new ArrayList<Product>();
    }

    public void addProductToDatabase(Product product){
        this.productDatabase.add(product);
    }

    public void deleteProductFromDatabase(Product product){
        this.productDatabase.remove(product);
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
