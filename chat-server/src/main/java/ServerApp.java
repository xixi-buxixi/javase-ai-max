import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServerApp {
    //定义一个集合记住所有的Socket对象
    public static final Map<Socket,String> socketMap = new ConcurrentHashMap<>();
    public static void main(String[] args)  {
        System.out.println("启动服务端系统");

        try {
            //1.创建一个ServerSocket对象，指定端口号
            ServerSocket ss = new ServerSocket(Constant.Port);
            //2.主线程负责接受客户端的连接请求
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = ss.accept();
                ServerThread st = new ServerThread(socket);
                st.start(); // 启动线程处理客户端连接

                System.out.println("客户端连接成功...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}