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

        Thread inventoryThread = new Thread(invTask1);
        Thread displayThread = new Thread(dispTask1);

            inventoryThread.start();
             Thread.sleep(2000);
//            Thread.sleep(20000);
           // inventoryThread.join(); // we'll wait until the inventoryThread has completed it's task
        // and joins the min thread
            displayThread.start();
    }
}
