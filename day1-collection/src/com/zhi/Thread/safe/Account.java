package com.zhi.Thread.safe;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String ID;
    private double balance;

    public void drawMoney(double i) {
        String threadName=Thread.currentThread().getName();
        synchronized (this){
            if(balance>=i){
                System.out.println(threadName+"取钱成功，取钱金额："+i);
                balance-=i;
                System.out.println(threadName+"取钱成功，余额："+balance);

            }else {
                System.out.println(threadName+"取钱失败，余额不足");
            }
        }
    }
}
