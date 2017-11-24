package com.jobready.producerconsumer;

import java.util.List;

/**
 * Created by Roman on 21.11.2017.
 */
public class Consumer  implements Runnable {

    List<Integer> questionList = null; // shared resource

    public Consumer(List<Integer> questionList){
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {

        synchronized (questionList) { // we'll specify the object to lock on
            while (  questionList.isEmpty() ) {
                System.out.println("NO Questions to answer... waitnig for producer to querstions !!!!!!!!!!!");
                questionList.wait();
                // we passing the control to any other thread that wants to access this questionList
                // we will wait until its notified to continue;
                // we'll pass control to the other block of code
                // to consumer thread
            }
        }

        synchronized (questionList) {
            Thread.sleep(2000);
            System.out.println("ANSWERED question: " + questionList.remove(0) );
            // we'll remove the first element. Like in a queue
            questionList.notify(); // that will wake up the thread that is waiting
            // to continue processing  "we have just answered a question"
            // so that other threads could resume
            // questionList.notifyAll(); - to notify all threads
            // that are waining to release that question list block
            // wait and notify can only be used inside synchronized() block
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                answerQuestion();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
