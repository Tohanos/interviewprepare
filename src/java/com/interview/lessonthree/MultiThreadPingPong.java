package com.interview.lessonthree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadPingPong {
    public static void main(String[] args) {
        Object sync = new Object();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new PrintTask("Ping", 100, sync));
        exec.execute(new PrintTask("Pong", 100, sync));
        exec.shutdown();
    }
}
