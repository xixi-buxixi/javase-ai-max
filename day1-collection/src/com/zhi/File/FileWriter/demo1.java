package com.zhi.File.FileWriter;

import java.io.FileWriter;
import java.io.Writer;

public class demo1 {
    public static void main(String[] args) {
        try(Writer writer=new FileWriter("day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt", true);){
            writer.write("hello world");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
