package com.zhi.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动...");
        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream out = socket.getOutputStream();

        DataOutputStream dos = new DataOutputStream(out);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据:");
            String data = sc.nextLine();
            if("exit".equals(data)){
                System.out.println("发送完毕..");
                socket.close();
                dos.close();
                break;
            }
            dos.writeUTF( data);
            dos.flush();
        }


    }
}
