package com.zhi.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动...");
        ServerSocket ss=new ServerSocket(10086);
        //调用accept，阻塞等待客户端连接，一旦客户端连接，返回一个Socket对象
        while (true) {
            Socket socket = ss.accept();
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"连接成功...");
            ServiceThread st = new ServiceThread(socket);
            st.start();
        }

    }
}
