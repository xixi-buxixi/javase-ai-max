package com.zhi.Thread.test;

import java.util.List;

public class GetRunnable extends Thread{
    private List<Integer> redPackets;
    private int i;
    private int sum;
    public GetRunnable(List<Integer> redPackets, String s, int i, int sum) {
        super(s);
        this.redPackets = redPackets;
        this.i = i;
        this.sum = sum;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while(true){
            synchronized (redPackets){
                if(redPackets.size()==0){
                    break;
                }
                int index=(int) Math.random()*redPackets.size();
                int money = redPackets.remove(index);
                sum+=money;
                System.out.println("第"+i+"人"+name+"抢到红包："+money);
                System.out.println("第"+i+"人"+name+"一共抢到红包："+sum);

                if(redPackets.size()==0){
                    System.out.println("抢完红包了");
                }
            }
        }
    }
}
