package com.jobready.producerconsumer;

import java.util.List;

/**
 * Created by Roman on 21.11.2017.
 */
public class Producer implements Runnable {

    List<Integer> questionList = null; // shared resource
    final int LIMIT = 5;
    private int questionNumber;

    public Producer(List<Integer> questionList){
        this.questionList = questionList;
        //this.questionNumber = 0;
    }

    public void readQuestion(int questionNumber) throws InterruptedException {

        synchronized (questionList) { // we'll specify the object to lock on
            while (questionList.size() >= LIMIT) {
                System.out.println("Questions have piled up... waitnig for answers");
                questionList.wait();
                // wex passing the control to any other threadt that wants to access this questionList
                // we will wait until its notified to continue;
                // we'll pass control to the other block of code
                // to consumer thread
            }
        }

        synchronized (questionList) {
            System.out.println("new question: " + questionNumber );
            questionList.add(questionNumber);
            Thread.sleep(100);
            questionList.notify(); // that will wake up the thread that is waiting
            // to continue processing
            // questionList.notifyAll(); - to notify all threadas
            // that are waining to release that question list block
            // wait and notify can only be used inside synchronized() block
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                readQuestion(questionNumber++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
