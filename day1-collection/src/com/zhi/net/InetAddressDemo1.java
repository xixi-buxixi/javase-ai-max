package com.zhi.net;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) {
        try{
            InetAddress ip1= InetAddress.getLocalHost();
            System.out.println(ip1.getHostName());
            System.out.println(ip1.getHostAddress());
            //获取对方IP对象
            InetAddress ip2= InetAddress.getByName("www.baidu.com");
            System.out.println(ip2.getHostName());
            System.out.println(ip2.getHostAddress());
            //判断本机与主机是否连通
            System.out.println(ip2.isReachable(3000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
