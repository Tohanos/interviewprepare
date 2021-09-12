package com.interview.lessonthree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentCounterTest {

    public static void main(String[] args) {
        class Task implements Runnable {
            private final ConcurrentCounter counter;
            private final int countTo;
            private final long sleepTimeout;

            public Task(int countTo, ConcurrentCounter counter, long sleepTimeout) {
                this.countTo = countTo;
                this.counter = counter;
                this.sleepTimeout = sleepTimeout;
            }

            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is started");
                for (int i = 0; i < countTo; i++) {
                    counter.increment();
                    System.out.println(counter.getCounter());
                    try {
                        TimeUnit.MILLISECONDS.sleep(sleepTimeout);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ConcurrentCounter counter = new ConcurrentCounter();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new Task(10, counter, 10));
        exec.execute(new Task(20, counter, 10));
        exec.shutdown();
        System.out.println(counter.getCounter());
    }
}
