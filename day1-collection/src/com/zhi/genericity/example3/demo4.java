package com.zhi.genericity.example3;

import java.util.ArrayList;

public class demo4 {
    public static void main(String[] args) {
        ArrayList<xiaomi> list=new ArrayList();
        list.add(new xiaomi());
        list.add(new xiaomi());
        list.add(new xiaomi());
        go(list);

        ArrayList<BWM> list2=new ArrayList();
        list2.add(new BWM());
        list2.add(new BWM());
        list2.add(new BWM());
        go(list2);
    }




    public static  void go(ArrayList<? extends car> cars){

    }
}
