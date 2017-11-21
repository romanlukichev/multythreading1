package com.jobready.inventory;

/**
 * Created by Roman on 20.11.2017.
 */
public class InventoryTask implements Runnable {

    InventoryManager manager;

    @Override
    public void run(){
        manager.populateSoldProducts();
    }

    public InventoryTask(InventoryManager inMamager){
        this.manager = inMamager;
    }
}
