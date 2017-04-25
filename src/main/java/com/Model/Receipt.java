package com.Model;

import java.util.ArrayList;

/**
 * Created by kram on 25.04.17.
 */
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
