package com.zhi.File.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        try(Reader reader=new FileReader("day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt");
            BufferedReader buffered=new BufferedReader(reader);
        ){
            String line;
            while((line=buffered.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
