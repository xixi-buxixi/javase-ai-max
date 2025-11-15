package com.zhi.File;

public class monkeyEat {
    //f(n)=f(n-1)/2-1
    //f(n-1)=2*f(n)+2;
    public static void main(String[] args) {
        int day=10;
        int remaining=1;
        int eat1 = eat(1);
        System.out.println(eat1);
    }
    public static int eat(int day){
        if(day==10){
            return 1;
        }
        else return 2*eat(day+1)+2;
    }
}
