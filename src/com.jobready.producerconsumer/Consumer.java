package com.jobready.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer  implements Runnable {

    BlockingQueue<Integer> questionQueue;

    public Consumer(BlockingQueue<Integer> questionQueue){
        this.questionQueue = questionQueue;
    }


    @Override
    public void run() {
        while (true) {
                    try {
                        Thread.sleep(1000);  // one second
                System.out.println("question answered: " + questionQueue.take());
                // take() - retrieve and remove element from the queue
                // you use put() and take() methods with blocking queue.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
