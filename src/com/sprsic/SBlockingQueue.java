package com.sprsic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Custom implementation of blocking queue.
 * Queue is backed by a linked list.
 *
 * @param <T>
 */
public class SBlockingQueue<T> {
    private final Queue<T> queue;
    private final int maxInQueue;

    public SBlockingQueue(int size) {
        this.maxInQueue = size;
        this.queue = new LinkedList<>();
    }

    /**
     * Put runnable task to the queue.
     *
     * @param task
     * @throws InterruptedException
     */
    public synchronized void enqueue(T task) throws InterruptedException {
        /*
         * wait until queue is has some room to put task
         */
        while (this.queue.size() == maxInQueue) {
            wait();
        }

        if (this.queue.size() < maxInQueue) {
            notifyAll();
        }

        this.queue.offer(task);
    }

    /**
     * Returns a task from the queue for execution.
     *
     * @return Task for execution.
     * @throws InterruptedException
     */
    public synchronized T dequeue() throws InterruptedException {
        /*
         * wait until there is a task in the queue
         * */
        while (this.queue.size() == 0) {
            wait();
        }

        if (this.queue.size() == maxInQueue) {
            notifyAll();
        }

        return this.queue.poll();
    }
}
