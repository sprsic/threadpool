package com.sprsic;

/**
 * Task executor that executes tasks from the queue.
 */
public class STaskExecutor implements Runnable {
    private SBlockingQueue<Runnable> queue;

    public STaskExecutor(SBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                Runnable task = queue.dequeue();
                System.out.println("Task started - " + Thread.currentThread().getName());
                task.run();
                System.out.println("Task finished - " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
