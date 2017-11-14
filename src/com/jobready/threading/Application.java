package com.jobready.threading;



import java.lang.*;

public class Application {

    public static void main(String[] args) {

        System.out.println("Starting thread B");
        Task taskRunner1 = new Task("thread-B");
        taskRunner1.start();

        System.out.println("Starting thread A");
        Task taskRunner2 = new Task("thread-A");
        taskRunner2.start();



    }

    static class Task extends Thread{
        private String name;
        public void run(){
            Thread.currentThread().setName(this.name);
            for( int i=0 ; i < 1000 ; i++ ){
                System.out.println( "number: " + i + " " + Thread.currentThread().getName() );
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        public Task(){
        }

        public Task(String name){
            this.name = name;
        }

        public void SetName(String name){
            this.name = name;
        }
    }
}
