package com.zhi.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) throws Exception {

        System.out.println("发送端启动..");
        Scanner sc = new Scanner(System.in);
        DatagramSocket socket=new DatagramSocket();//随机端口

        //创建数据
        while (true) {
            System.out.println("请输入要发送的数据:");
            String data = sc.nextLine();
            if("exit".equals(data)){
                System.out.println("发送完毕..");
                socket.close();
                break;
            }
            byte[] bytes = data.getBytes();
            //创建数据包，并指定发送的地址和端口
            DatagramPacket packet=new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 10086);
            socket.send( packet);
        }
    }
}
