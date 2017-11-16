package com.jobready.threading;

/**
 * Created by Roman on 15.11.2017.
 */
public class Sequence {

    private int value = 0;

    public synchronized int getNext() {
        synchronized (this) {
            value++;
            return value;

        }
    }
}
