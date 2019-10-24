package com.sprsic;

public class Main {

    public static void main(String[] args) {
        /**
         * Thread pool has capacity of holding 10 tasks and 2 threads for executing
         */
        SThreadPool threadPool = new SThreadPool(10, 2);

        try {
            for (int i = 0; i <= 7; i++) {
                DummyTask t = new DummyTask(i);
                threadPool.submitTask(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Interupted exception: " + e);
        }
        System.out.println("FINISH");
    }
}
