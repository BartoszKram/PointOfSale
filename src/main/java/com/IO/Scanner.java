package com.IO;

public class Scanner {

    public String scan(String barcode){
        if(barcode.length()==0){
            return "Invalid bar-code";
        }
        else{
            return barcode;
        }
    }

}
