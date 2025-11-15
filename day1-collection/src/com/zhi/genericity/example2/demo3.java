package com.zhi.genericity.example2;

public class demo3 {
    public static void main(String[] args) {
        String[] names={"zhi","zhi","zhi"};
        System.out.println(printArray(names));
    }



    public static <T> T printArray(T[] t){
        return t[0];
    }
    public static <T> void getMax(T t){

    }
}
