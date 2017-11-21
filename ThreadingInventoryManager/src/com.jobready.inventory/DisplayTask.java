package com.jobready.inventory;

/**
 * Created by Roman on 20.11.2017.
 */
public class DisplayTask implements Runnable {
    InventoryManager manager;

    @Override
    public void run(){
        manager.displaySoldProducts();
    }

    public  DisplayTask(InventoryManager inMamager){
        this.manager = inMamager;
    }

}