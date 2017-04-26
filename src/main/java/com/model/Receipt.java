package com.model;

import java.util.ArrayList;

public class Receipt {

    private ArrayList<Product> productList;
    private double total;

    public Receipt(){
        productList = new ArrayList<Product>();
        total = 0.0;
    }

    public void addProduct(Product product){
        productList.add(product);
        total += product.getPrice();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public double getTotal() {
        return total;
    }
}
