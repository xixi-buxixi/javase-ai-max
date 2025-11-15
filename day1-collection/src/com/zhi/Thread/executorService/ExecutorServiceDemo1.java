package com.zhi.Thread.executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        ExecutorService pool=new ThreadPoolExecutor(3,5,
                10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable task=new MyRunnable();
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);//创建临时线程时机 ： 创建临时线程时机 ： 线程池中的线程数达到最大线程数，且任务队列已满
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);//创建临时线程时机 ： 线程池中的线程数达到最大线程数，且任务队列已满

        pool.shutdown();
    }
}
