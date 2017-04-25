package com.IO;

import com.Model.Receipt;

/**
 * Created by kram on 25.04.17.
 */
public class Printer {

    public void displayReceipt(Receipt receipt){
        for(int i=0;i<receipt.getProductList().size();i++){
            System.out.printf("%s Price: %f\n",receipt.getProductList().get(i).getName(),receipt.getProductList().get(i).getPrice());
        }
        System.out.printf("Total price: %f\n",receipt.getTotal());
    }
}
