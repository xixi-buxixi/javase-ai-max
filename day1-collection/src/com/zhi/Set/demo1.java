package com.zhi.Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class demo1 {
    public static void main(String[] args) {
       /* Set<Student> set=new HashSet<>();
        Student s1=new Student("zs",18);
        Student s2=new Student("ls",19);
        Student s3=new Student("zs",18);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set);*/

        Set<Teacher> set=new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        Teacher t1=new Teacher("zs",18,3030.4);
        Teacher t2=new Teacher("ls",19,3020.4);
        Teacher t3=new Teacher("zs",18,3030.4);
        set.add(t1);
        set.add(t2);
        set.add(t3);
        System.out.println(set);
    }
}
