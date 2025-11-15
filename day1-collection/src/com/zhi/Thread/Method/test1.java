package com.zhi.Thread.Method;

public class test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        t.start();
        for (int i = 0; i < 5; i++){
            Thread.sleep(500);
            if(i==3){
                t.join();

            }
            System.out.println("主线程输出：" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(2000); // 让子线程慢一些
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程输出：" + i);
        }
    }
}
