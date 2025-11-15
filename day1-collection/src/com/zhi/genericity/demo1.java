package com.zhi.genericity;

import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList();
        list.add("java");
        list.add("c");
        list.add("c++");
        list.add("python");



        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
