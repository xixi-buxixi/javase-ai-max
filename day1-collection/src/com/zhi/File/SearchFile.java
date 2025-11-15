package com.zhi.File;

import java.io.File;

import static com.sun.tools.attach.VirtualMachine.list;

public class SearchFile {
    public static void main(String[] args) {
        File dir=new File("D:\\");
        searchFile(dir,"QQ.exe");
    }

    private static void searchFile(File dir, String s) {
        //判断极端情况
        if(dir== null||!dir.exists()|| dir.isFile()){
            return ;
        }
        //搜索D盘下的文件是否有需要查找的文件
        File[] files = dir.listFiles();
        //判断当前目录下是否存在一级文件对象
        if(files!= null&& files.length>0) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(s)) {
                        System.out.println(file.getAbsolutePath());
                    }
                } else  searchFile(file, s);
            }
        }
    }
}
