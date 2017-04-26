package com.IO;

import com.model.Receipt;

public class Printer {

    public void displayReceipt(Receipt receipt){
        for(int i=0;i<receipt.getProductList().size();i++){
            System.out.printf("%s Price: %.2f\n",receipt.getProductList().get(i).getName(),receipt.getProductList().get(i).getPrice());
        }
        System.out.printf("Total price: %.2f\n",receipt.getTotal());
    }
}
