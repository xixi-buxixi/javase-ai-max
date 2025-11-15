package com.zhi.File.fileInput;

import java.io.*;

public class CopyDemo1 {
    public static void main(String[] args) throws Exception {
        copyFile("day1-collection\\src\\com\\zhi\\File\\fileInput\\example2.txt","day1-collection\\src\\com\\zhi\\File\\fileInput\\example.txt");

    }
    public static void copyFile(String srcPatch,String destPath) throws IOException {
        try (OutputStream os=new FileOutputStream(destPath);
             InputStream is=new FileInputStream(srcPatch);
             myConn conn=new myConn();
             )
        {
            byte[] bytes=new byte[3];
            int read;
            while ((read=is.read(bytes))!=-1){
                os.write(bytes,0,read);
                System.out.println("复制了"+read+"字节");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static class myConn implements Closeable{
        @Override
        public void close() throws IOException {
            System.out.println("关闭了连接");
        }
    }
}
