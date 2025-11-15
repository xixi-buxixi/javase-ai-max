package com.zhi.Thread.safe;

public class DrawThread extends Thread{
    private Account account;
    DrawThread(Account account){
        this.account = account;
    }
    @Override
    public void run() {
        account.drawMoney(100000);
    }
}
