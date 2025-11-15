package com.zhi.net.tcp2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class serverDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动...");
        ServerSocket ss=new ServerSocket(8080);
        //创建一个线程池
        ExecutorService es=new ThreadPoolExecutor(3,10,100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),new ThreadPoolExecutor.DiscardOldestPolicy());
        //调用accept，阻塞等待客户端连接，一旦客户端连接，返回一个Socket对象
        while (true) {
            Socket socket = ss.accept();
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"连接成功...");
            es.execute(new ServiceThread(socket));

        }

    }
}
