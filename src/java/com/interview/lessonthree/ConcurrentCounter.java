package com.interview.lessonthree;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCounter {
    private volatile long counter = 0;
    private final Lock lock = new ReentrantLock(true);

    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public long getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }

    }
}
