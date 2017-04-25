package com.IO;

/**
 * Created by kram on 25.04.17.
 */
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
