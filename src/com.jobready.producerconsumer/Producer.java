package com.jobready.producerconsumer;


import java.util.concurrent.BlockingQueue;

/**
 * Created by Roman on 21.11.2017.
 */
public class Producer implements Runnable {

    int questionNumber; // will be zero by default
    BlockingQueue<Integer> questionQueue;

    public Producer(BlockingQueue<Integer> questionQueue){
         this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while (true) {

                    try {
                        synchronized (this) {
                            int nextQuestion = questionNumber++;
                            System.out.println("Got new question: " + nextQuestion);
                            questionQueue.put(nextQuestion);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        }
    }

}
