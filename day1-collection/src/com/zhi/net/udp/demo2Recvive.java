package com.zhi.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class demo2Recvive {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动中...");
        DatagramSocket socket=new DatagramSocket(10086);
        //创建数据包负责接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length);

        //接收数据,将数据存入packet1
        while (true) {
            socket.receive(packet1);//接收数据
            //System.out.println(new String(bytes));
            //获取数据长度
            int length = packet1.getLength();
            //获取对方 IP和程序端口
            String ip=packet1.getAddress().getHostAddress();
            int port=packet1.getPort();

            System.out.println("来自"+ip+":"+port+"的数据为:"+new String(bytes,0,length));
            System.out.println("=================================");
        }

    }
}
