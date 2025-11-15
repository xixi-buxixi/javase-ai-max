package com.zhi.Map;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        List<String> lists=new ArrayList<>();
        String[] names={"A","B","C","D"};
        Random ra=new Random();
        for (int i=0;i<80;i++){
            int index=ra.nextInt(names.length);
            lists.add(names[index]);
        }

        Map<String,Integer> map=new HashMap<>();
        for(String name:lists){
//            if(map.containsKey(name)){
//                map.put(name,map.get(name)+1);
//            }else {
//                map.put(name,1);
//            }
            //简化
            map.put(name,map.containsKey(name)?map.get(name)+1:1);
        }
        map.forEach((k,v)-> System.out.println(k+"--->"+v));
    }
}
