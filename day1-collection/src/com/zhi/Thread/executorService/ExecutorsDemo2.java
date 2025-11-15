package com.zhi.Thread.executorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo2 {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(3);
    }
}
