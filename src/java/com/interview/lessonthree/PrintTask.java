package com.interview.lessonthree;

import java.util.concurrent.TimeUnit;

public class PrintTask implements Runnable{
    private final String value;
    private final long sleepTime;
    private final Object syncObject;

    public PrintTask(String value, long sleepTime, Object syncObject) {
        this.value = value;
        this.sleepTime = sleepTime;
        this.syncObject = syncObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (syncObject) {
                try {
                    System.out.println(value);
                    syncObject.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                    syncObject.wait(sleepTime + 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
