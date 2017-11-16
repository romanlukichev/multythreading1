package com.jobready.threading;

/**
 * Created by Roman on 15.11.2017.
 */
public class Worker extends Thread{

    Sequence sequence1 = null;

    public Worker(Sequence sequence){
        this.sequence1 = sequence;
    }

    public void run(){
        for(int i=0 ; i<100 ; i++ ){
            System.out.println( Thread.currentThread().getName() + "-th, value=" +   sequence1.getNext());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}