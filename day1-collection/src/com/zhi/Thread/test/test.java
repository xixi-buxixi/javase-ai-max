package com.zhi.Thread.test;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //准备两百个红包
        List<Integer> redPackets = getRedPacket();
        for(int i=1;i<=100;i++){
            int sum=0;
            new GetRunnable(redPackets,"人",i,sum).start();
        }

    }
    public static List<Integer> getRedPacket(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 160; i++){
            int money = (int)(Math.random()*30)+1;
            list.add(money);
        }
        for (int i = 0; i < 40; i++){
            int money = (int)(Math.random()*70)+1;
            list.add(money);
        }
        return list;
    }
}
