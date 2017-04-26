package com;

import com.IO.LCDdisplay;
import com.IO.Printer;
import com.IO.Scanner;
import com.model.Product;
import com.model.Receipt;
import com.service.Controller;
import com.database.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException{
        Database database = new Database();
        database.addProductToDatabase(new Product("Chocolate bar", "123451",3.99));
        database.addProductToDatabase(new Product("Juice","123452",4.99));
        database.addProductToDatabase(new Product("Ticket","123453", 10.50));

        Controller controller= new Controller(new LCDdisplay(),new Scanner(),new Printer(), database, new Receipt());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Scan product");
            String input = br.readLine();
            controller.service(input);
            if(input.equals("exit")){
                break;
            }
        }
    }
}
