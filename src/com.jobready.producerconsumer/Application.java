package com.jobready.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Roman on 21.11.2017.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);

        Thread t1 = new Thread(new Producer(questionQueue));
        Thread t2 = new Thread(new Consumer(questionQueue));

        t1.start();

        t2.start();
    }
}
