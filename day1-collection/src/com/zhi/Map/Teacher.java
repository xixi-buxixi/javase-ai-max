package com.zhi.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;
    private double salary;

    @Override
    public int compareTo(Teacher o) {
//        if(this.age==o.age){
//            return 1;
//        }
        return this.getAge()-o.getAge();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
