package com.zhi.net.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class timeDemo1 {
    public static void main(String[] args) {
        //LocalDate LocalTime LocalDateTime 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //格式化:DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(now);
        System.out.println(format);
    }
}
