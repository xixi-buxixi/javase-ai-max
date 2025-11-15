package com.zhi.exception;

public class demo1 {
    public static void main(String[] args) throws Exception {
        System.out.println();
    }


    public static void setAge(int age) throws AgeIllegal {
        if(age < 0 || age > 120){
            throw new AgeIllegal("年龄非法"); 
        }
        System.out.println("年龄合法");
    }

}
