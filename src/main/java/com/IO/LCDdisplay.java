package com.IO;

import com.model.Product;

public class LCDdisplay {

    public void displayInfo(String info){
        System.out.println(info);
    }

    public void displayTotal(Double total){
        System.out.printf("Total: %.2f\n", total);
    }

    public void displayProduct(Product product){
        System.out.printf("%s Price: %.2f\n",product.getName(),product.getPrice());
    }

}
