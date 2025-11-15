package com.zhi.File.printStream;

import java.io.PrintStream;

public class demo1 {
    public static void main(String[] args) {
        try(PrintStream ps=new PrintStream("day1-collection\\src\\com\\zhi\\File\\example2.txt")){
            ps.println("hello world");
            ps.println(123);
            ps.println(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
