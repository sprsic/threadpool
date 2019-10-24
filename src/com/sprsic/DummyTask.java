package com.sprsic;

/**
 * Implementation of dummy task just to keep executor busy.
 */
public class DummyTask implements Runnable {
    private int taskNumber;

    public DummyTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Running dummy task-" + this.taskNumber);
    }
}
