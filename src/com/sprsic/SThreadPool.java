package com.sprsic;


public class SThreadPool {
    private int size;
    private int threadsNumber;
    private SBlockingQueue<Runnable> queue;

    private Thread[] threads;
    private STaskExecutor taskExecutor;

    public SThreadPool(int size, int threadsNumber) {
        queue = new SBlockingQueue<>(size);
        this.size = size;
        this.threadsNumber = threadsNumber;
        this.threads = new Thread[size];
        taskExecutor = new STaskExecutor(queue);
        for (int i = 0; i < threadsNumber; i++) {
            String threadName = "Thread_" + i;
            threads[i] = new Thread(taskExecutor, threadName);
            threads[i].start();
        }
    }

    public void submitTask(Runnable runnable) throws InterruptedException {
        this.queue.enqueue(runnable);
    }
}
