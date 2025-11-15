import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ReaderThread extends Thread {
    private Socket socket;
    private chatRoom chatRoom;
    private DataInputStream ds;
    private volatile boolean running = true;

    public ReaderThread(chatRoom chatRoom, Socket socket) {
        this.chatRoom = chatRoom;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ds = new DataInputStream(socket.getInputStream());

            while (running && !socket.isClosed()) {
                try {
                    int type = ds.readInt();
                    switch (type) {
                        case 1:
                            updateUser();
                            break;
                        case 2:
                            getMessage();
                            break;
                        default:
                            System.out.println("未知消息类型: " + type);
                    }
                } catch (EOFException e) {
                    System.out.println("服务器连接断开");
                    break;
                } catch (IOException e) {
                    if (!socket.isClosed()) {
                        System.out.println("读取服务器消息时出错: " + e.getMessage());
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("连接服务器失败: " + e.getMessage());
        } finally {
            running = false;
            chatRoom.addChatMessage("系统: 与服务器的连接已断开");
        }
    }

    private void getMessage() {
        try {
            String message = ds.readUTF();
            chatRoom.addChatMessage(message);
        } catch (IOException e) {
            System.out.println("读取消息失败: " + e.getMessage());
        }
    }

    private void updateUser() {
        try {
            int count = ds.readInt();
            String[] onlineUsers = new String[count];
            for (int i = 0; i < count; i++) {
                String name = ds.readUTF();
                onlineUsers[i] = name;
            }
            System.out.println("更新在线用户: " + String.join(", ", Arrays.asList(onlineUsers)));
            chatRoom.updateOnlineUsers(onlineUsers);
        } catch (IOException e) {
            System.out.println("更新用户列表失败: " + e.getMessage());
        }
    }

    public void stopReading() {
        running = false;
        try {
            if (ds != null) {
                ds.close();
            }
        } catch (IOException e) {
            // 忽略关闭异常
        }
    }
}