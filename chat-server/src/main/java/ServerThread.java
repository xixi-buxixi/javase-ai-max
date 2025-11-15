import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerThread extends  Thread{
    private Socket socket;
    private String nickname;
    private volatile boolean running = true;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("开始处理客户端: " + socket.getInetAddress().getHostAddress());
        try(InputStream is = socket.getInputStream();
            DataInputStream ds=new DataInputStream(is);)
        {
            //接受的消息类型：1.登陆消息（昵称）2.群聊消息3.私聊消息4.退出消息
            //客户端必须声明协议，服务端必须按照协议处理

            while (running && !socket.isClosed()) {
                int type = ds.readInt();
                switch (type) {
                    case 1:
                        //接受昵称，更新在线列表
                        String nickname = ds.readUTF();
                        System.out.println(nickname+"已上线");
                        this.nickname = nickname;
                        synchronized (ServerApp.socketMap) {
                            ServerApp.socketMap.put(socket, nickname);
                        }
                        updateSocketMap();
                        break;
                    case 2:
                        //群聊消息
                        String message = ds.readUTF();
                        sendMessageToAll(message);
                        break;
                    case 3:
                        //私聊消息
                        break;
                    case 4:
                        //退出消息
                        break;
                    default:
                        System.out.println("未知消息类型");
                }
            }
        } catch (IOException e) {
            System.out.println("客户端连接断开: " + (nickname != null ? nickname : "未知用户"));
        } catch (Exception e) {
            System.out.println("处理客户端消息时出错: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendMessageToAll(String msg) {
        //首先拼接群聊消息
        StringBuilder sb = new StringBuilder();
        String name= ServerApp.socketMap.get(socket);
        //拼接时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(now);

        String formattedMsg=sb.append(name).append(":").append(format).append("/r/n").append(":").append(msg).toString();
        synchronized (ServerApp.socketMap) {
            for (Socket clientSocket : ServerApp.socketMap.keySet()) {
                if (clientSocket != socket && !clientSocket.isClosed()) {
                    try (OutputStream os = clientSocket.getOutputStream();
                         DataOutputStream dos = new DataOutputStream(os)) {
                        dos.writeInt(2);
                        dos.writeUTF(formattedMsg);
                        dos.flush();
                    } catch (IOException e) {
                        System.out.println("发送消息失败: " + e.getMessage());
                        // 移除失效的连接
                        ServerApp.socketMap.remove(clientSocket);
                    }
                }
            }
        }

    }

    private void updateSocketMap() {
        Collection<String> onlineNicknames;
        synchronized (ServerApp.socketMap) {
            onlineNicknames = ServerApp.socketMap.values();
        }

        String[] nicknames = onlineNicknames.toArray(new String[0]);

        synchronized (ServerApp.socketMap) {
            for (Socket clientSocket : ServerApp.socketMap.keySet()) {
                if (!clientSocket.isClosed()) {
                    try (OutputStream os = clientSocket.getOutputStream();
                         DataOutputStream dos = new DataOutputStream(os)) {
                        dos.writeInt(1);
                        dos.writeInt(nicknames.length);
                        for (String nickname : nicknames) {
                            dos.writeUTF(nickname);
                        }
                        dos.flush();
                    } catch (IOException e) {
                        System.out.println("更新在线列表失败: " + e.getMessage());
                        // 移除失效的连接
                        ServerApp.socketMap.remove(clientSocket);
                    }
                }
            }
        }
    }
}
