package com.zhi.File.fileInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputDemo1 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt");
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        while (read != -1) {
            System.out.println(new String(bytes, 0, read));
            read = inputStream.read(bytes);
        }
        inputStream.close();
    }
}
