package com.jobready.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 16.11.2017.
 */
public class InventoryManager {
    List<Product> SoldProguctsList = new ArrayList<Product>(); // both threads will be accessing this List
    List<Product> PurchasedProguctsList = new ArrayList<Product>();

    public void populateSoldProducts(){
        for(int i = 0; i<1000; i++){
              Product prod = new Product(i , "test_product_" + i );
              SoldProguctsList.add(prod);
            System.out.println("Added: " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts(){
        for(Product product : SoldProguctsList){
            System.out.println("displaySoldProducts() : " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
