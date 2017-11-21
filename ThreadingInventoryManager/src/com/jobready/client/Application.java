package com.jobready.client;
import com.jobready.inventory.DisplayTask;
import com.jobready.inventory.InventoryManager;
import com.jobready.inventory.InventoryTask;

/**
 * Created by Roman on 16.11.2017.
 */
public class Application {

    public static void main(String[] args) throws InterruptedException {

    InventoryManager manager;
        manager = new InventoryManager();


        InventoryTask invTask1 = new InventoryTask(manager);
        DisplayTask  dispTask1 = new DisplayTask(manager);

        Thread t1 = new Thread(invTask1);
        Thread t2 = new Thread(dispTask1);




            t1.start();
            Thread.sleep(2000);
            t2.start();
    }
}
