package com.zhi.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class text1 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("张三",18);
        map.put("王五",19);
        map.put("赵六",20);
        //方法一：获取所有的键
        Set<String> keys=map.keySet();
        for(String key:keys){
            Integer value=map.get(key);
            System.out.println(key+"--"+value);
        }
        //方法二：map.entrySet()
//        Set<Map.Entry<String,Integer>> entrys=map.entrySet();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry:entries){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

        //方法三：lambda
//        map.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String s, Integer v) {
//                System.out.println(s+"--"+v);
//            }
//        });
        map.forEach((s,v)-> System.out.println(s+"--"+v));


    }
}
