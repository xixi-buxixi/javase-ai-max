package com.zhi.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServiceThread extends Thread{
    private Socket socket;
    public ServiceThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try ( InputStream is = socket.getInputStream();
              DataInputStream dis = new DataInputStream(is);)
        {
            while(true){
                System.out.println(dis.readUTF());
                //客户端IP
                System.out.println(socket.getInetAddress().getHostAddress());
                System.out.println(socket.getPort());
                System.out.println("=================================");

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已断开");
        }
    }
}
