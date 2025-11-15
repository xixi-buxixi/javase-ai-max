package com.zhi.genericity.example;

public class StudentData implements  data<Student>{
    @Override
    public void add(Student s){
        System.out.println("添加学生");
    }
    public void delete(){
        System.out.println("删除学生");
    }
    @Override
    public Student get(int id){
        return null;
    }
}
