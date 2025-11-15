package com.zhi.Map;

import java.util.Map;
import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args) {
        Map<Teacher,String> map=new TreeMap<>((o1,o2)->Double.compare(o2.getSalary(),o1.getSalary()));
        map.put(new Teacher("张三",18,5000),"1期");
        map.put(new Teacher("王五",19,5001),"2期");
        map.put(new Teacher("赵六",20,5023),"3期");
        System.out.println( map);
    }
}
