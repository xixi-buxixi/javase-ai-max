package com.zhi.File.inputStreamReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class demo1 {
    public static void main(String[] args) {
        try( FileInputStream is=new FileInputStream("day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt");
             InputStreamReader reader=new InputStreamReader(is,"utf-8");
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
