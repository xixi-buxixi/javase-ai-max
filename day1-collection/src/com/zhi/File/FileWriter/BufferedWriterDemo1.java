package com.zhi.File.FileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferedWriterDemo1 {
    public static void main(String[] args) {
        try(FileWriter fw=new FileWriter("day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt", true);
            BufferedWriter bw=new BufferedWriter(fw);){
            bw.newLine();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
