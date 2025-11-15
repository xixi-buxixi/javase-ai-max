package com.zhi.Collection;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("java");
        list.add("c");
        list.add("c++");
        list.add("c#");
        list.add("python");
        for(String lis:list){
            System.out.println(lis);
        }
        System.out.println("---------------------");
        //解决并发修改异常问题
        //方法一:适合有索引的   i--
        for(int i=0;i< list.size();i++){
            String name=list.get(i);
            if(name.contains("c")){
                list.remove(name);
                i--;
            }
        }
        for(String lis:list){
            System.out.println(lis);
        }
        System.out.println("----------------------------");

        //方案二：适合有索引的 倒序
        ArrayList<String> list2 =new ArrayList<>();
        list2.add("java");
        list2.add("c");
        list2.add("c++");
        list2.add("c#");
        list2.add("python");
        for(int i=list2.size()-1;i>=0;i--){
            String name=list2.get(i);
            if(name.contains("c")){
                list2.remove(name);
            }
        }
        for(String lis:list2){
            System.out.println(lis);
        }
        System.out.println("----------------------------");



        //方案三：迭代器
        ArrayList<String> list3 =new ArrayList<>();
        list3.add("java");
        list3.add("c");
        list3.add("c++");
        list3.add("c#");
        list3.add("python");
        Iterator<String> name=list3.iterator();
        while(name.hasNext()){
            String na=name.next();
            if(na.contains("c")){
                name.remove();
            }
        }
        for(String lis:list3){
            System.out.println(lis);
        }
    }
}
