package com.zhi.File;

import java.io.*;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        try(Reader reader=new FileReader("day1-collection\\src\\com\\zhi\\File\\graduationTable.txt");
            Writer writer=new FileWriter("day1-collection\\src\\com\\zhi\\File\\normal.txt");
            BufferedReader buffered=new BufferedReader(reader);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
        ) {
            String line;
            List<String> list = new ArrayList<>();
            while ((line = buffered.readLine()) != null ) {
                list.add(line);
            }
            Collections.sort( list);
            System.out.println( list);
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
