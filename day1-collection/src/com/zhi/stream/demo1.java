package com.zhi.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo1 {
    public static void main(String[] args) {
//        Collection<String> list=new ArrayList<>();
//        Map<String,String> map=new HashMap<>();
//        String[] names={"张三","李四","王五"};
//        //Collection集合获取流
//        Stream<String> stream = list.stream();
//        //Map集合获取流
//        Stream<String> stream1 = map.values().stream();
//        Stream<String> stream2 = map.keySet().stream();
//        Stream<Map.Entry<String, String>> stream3 = map.entrySet().stream();
//
//        //数组获取流
//        Stream<String> stream4 = Stream.of(names);
//        Stream<String> stream5 = Stream.of("张三","李四","王五");


//中间方法

//        Double[] scores={80.0,90.0,100.0,60.0};
//        Stream<Double> stream6 = Stream.of(scores);
//        Stream.of(scores).filter(s->s>90).forEach(System.out::println);
//        Arrays.stream(scores).sorted().forEach(System.out::println);//升序
//        Arrays.stream(scores).sorted((a,b)->-a.compareTo(b)).forEach(System.out::println);//降序
//        Arrays.stream(scores).limit(2).forEach(System.out::println);
//        Arrays.stream(scores).skip(2).forEach(System.out::println);
//        Arrays.stream(scores).distinct().forEach(System.out::println);
//        Arrays.stream(scores).map(s->s+10).forEach(System.out::println);




        List<Teacher> list=new ArrayList<>();
        list.add(new Teacher("张三",18,5000));
        list.add(new Teacher("李四",19,6000));
        list.add(new Teacher("王五",20,7000));
        list.add(new Teacher("赵六",21,8000));
        List<Teacher> list1 = new ArrayList<>();
        Stream<Teacher> teacherStream = list.stream().filter(t -> t.getAge() > 18);
        //collect 将流中的数据映射为集合
        List<Teacher> collect = teacherStream.collect(Collectors.toList());
        System.out.println(collect);

        List<Teacher> list2=new ArrayList<>();
        list2.add(new Teacher("张三",18,5000));
        list2.add(new Teacher("李四",19,6000));
        list2.add(new Teacher("王五",20,7000));
        list2.add(new Teacher("赵六",21,8000));

        //collect 将流中的数据映射为数组
        Stream<Teacher> limit = list2.stream().limit(3);
        Teacher[] teachers = limit.toArray(Teacher[]::new);
        System.out.println(Arrays.toString(teachers));


        List<Teacher> list3=new ArrayList<>();
        list3.add(new Teacher("张三",18,5000));
        list3.add(new Teacher("李四",19,6000));
        list3.add(new Teacher("王五",20,7000));
        list3.add(new Teacher("赵六",21,8000));
        Stream<Teacher> skip = list3.stream();
        Map<String,Double> map=skip.collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        System.out.println(map);
    }
}
