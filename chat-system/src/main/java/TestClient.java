// TestClient.java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {
        try {
            System.out.println("连接服务器...");
            Socket socket = new Socket("127.0.0.1", 10086);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // 发送登录消息
            System.out.println("发送登录消息...");
            dos.writeInt(1);
            dos.writeUTF("TestUser");
            dos.flush();

            // 等待服务器响应
            System.out.println("等待服务器响应...");
            int responseType = dis.readInt();
            String responseMsg = dis.readUTF();
            System.out.println("服务器响应: type=" + responseType + ", msg=" + responseMsg);

            if (responseType == 99) {
                System.out.println("登录成功!");

                // 发送测试消息
                Thread.sleep(1000);
                System.out.println("发送测试消息...");
                dos.writeInt(2);
                dos.writeUTF("Hello Server!");
                dos.flush();
                System.out.println("测试消息发送成功");

                // 等待一段时间接收消息
                Thread.sleep(5000);
            } else {
                System.out.println("登录失败: " + responseMsg);
            }

            socket.close();
            System.out.println("测试完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}