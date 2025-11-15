package com.zhi.Thread.create;

public class app {
    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();

        for(int i=0;i<10;i++){
            System.out.println("main:"+i);
        }
    }
}
