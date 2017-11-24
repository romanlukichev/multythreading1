package com.jobready.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 21.11.2017.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> questionList = new ArrayList<Integer>();

        Thread t1 = new Thread(new Producer(questionList));
        Thread t2 = new Thread(new Consumer(questionList));

        t1.start();
        //Thread.sleep(3000);
        t2.start();
    }
}
