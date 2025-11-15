package com.zhi.File.fileInput;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputDemo1 {
    public static void main(String[] args) throws Exception{
        OutputStream os=new FileOutputStream("day1-collection\\src\\com\\zhi\\File\\fileInput\\example2.txt");
        os.write('a');
        os.write('b');
        os.write('c');
        os.write("\r\n".getBytes());
        byte[] bytes="中国".getBytes();
        os.write(bytes);
        os.write(bytes,0,3);
        os.close();

    }
}
