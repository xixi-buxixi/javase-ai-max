package com.zhi.Thread.safe;

public class app {
    public static void main(String[] args) {
        Account acc=new Account("ICBC-101",100000);
        Thread t1=new DrawThread(acc);
        t1.setName("小红");
        Thread t2=new DrawThread(acc);
        t2.setName("小王");
        t1.start();
        t2.start();
    }
}
