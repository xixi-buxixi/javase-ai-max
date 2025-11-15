package com.zhi.net.tcp2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServiceThread extends Thread{
    private Socket socket;
    public ServiceThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream os=socket.getOutputStream();
             PrintStream ps=new PrintStream(os);)
        {
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html");
            ps.println();
            ps.println("<html>");
            ps.println("<body>");
            ps.println("<h1>hello world</h1>");
            ps.println("</body>");
            ps.println("</html>");
            ps.flush();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("浏览器"+socket.getInetAddress().getHostAddress()+"已断开");
        }
    }
}
