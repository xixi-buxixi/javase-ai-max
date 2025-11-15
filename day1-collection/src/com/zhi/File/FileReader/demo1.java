package com.zhi.File.FileReader;

import java.io.FileReader;
import java.io.Reader;

public class demo1 {
    public static void main(String[] args) {
        try(Reader reader=new FileReader("day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt");){
            char[] chars=new char[3];
            int read;
            while((read=reader.read(chars))!=-1){
                System.out.println(new String(chars,0,read));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
