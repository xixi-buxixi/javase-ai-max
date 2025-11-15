package com.zhi.Thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MethodThree {
    public static void main(String[] args) {
        Callable<String> c1=new MyCallable(100);
        Callable<String> c2=new MyCallable(50);
        FutureTask<String> ft1=new FutureTask<>(c1);
        FutureTask<String> ft2=new FutureTask<>(c2);
        new Thread(ft1).start();
        new Thread(ft2).start();
        try {
            System.out.println(ft1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(ft2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<String> {
    private int count = 0;
    MyCallable(int count){
        this.count = count;
    };
    @Override
    public String call() throws Exception {
        int sum=0;
        for (int i = 0; i < count; i++){
            sum+=i;
        }
        return "子线程计算的结果"+ count+"是"+sum;
    }
}