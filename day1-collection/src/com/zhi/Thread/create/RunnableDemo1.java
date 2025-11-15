package com.zhi.Thread.create;

public class RunnableDemo1 {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i = 0; i < 5; i++){
                System.out.println("子线程输出：" + i);
            }
        }).start();
        for(int i = 0; i < 5; i++){
            System.out.println("主线程输出：" + i);
        }
    }
}



