package com.IO;

import com.Model.Product;

/**
 * Created by kram on 25.04.17.
 */
public class LCDdisplay {

    public void displayInfo(String info){
        System.out.println(info);
    }

    public void displayTotal(Double total){
        System.out.printf("Total: %f\n", total);
    }

    public void displayProduct(Product product){
        System.out.printf("%s Price: $f\n",product.getName(),product.getPrice());
    }

}
