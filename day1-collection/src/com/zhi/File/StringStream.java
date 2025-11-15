package com.zhi.File;

import java.io.UnsupportedEncodingException;

public class StringStream {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="我c666尼德";
        byte[]  bytes=str.getBytes();
        System.out.println( bytes.length);
        System.out.println(bytes.toString());

        System.out.println("=============");
        byte[] gbks = str.getBytes("GBK");
        System.out.println( gbks.length);
        System.out.println(gbks.toString());

    }
}
