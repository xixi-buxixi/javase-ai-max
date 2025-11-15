// chatRoom.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class chatRoom extends JFrame {
    private JTextArea chatDisplayArea;     // 聊天记录显示区域
    private JTextArea messageInputArea;    // 消息输入区域
    private JTextArea onlineUsersArea;     // 在线用户显示区域
    private JList<String> onlineUsersList=new JList<>();
    private JButton sendButton;            // 发送按钮
    private Socket socket;
    private String nickname;


    public chatRoom() {
        initializeComponents();
        setupLayout();
        addEventListeners();
        setupWindow();
    }

    public chatRoom(String nickname, Socket socket) {
        this();
        this.socket = socket;
        this.setTitle("聊天室-"+nickname);
        //立即把客户端的Socket交给一个独立的线程，专门负责读取从服务器收到的在线人数更新或者群聊信息
        new ReaderThread(this, socket).start();
    }

    private void initializeComponents() {
        setTitle("聊天室");

        // 聊天记录显示区域
        chatDisplayArea = new JTextArea(15, 30);
        chatDisplayArea.setEditable(false);
        chatDisplayArea.setLineWrap(true);
        chatDisplayArea.setWrapStyleWord(true);

        // 消息输入区域
        messageInputArea = new JTextArea(5, 30);
        messageInputArea.setLineWrap(true);
        messageInputArea.setWrapStyleWord(true);

        // 在线用户显示区域
        onlineUsersList.setFixedCellWidth(120);
        onlineUsersList.setVisibleRowCount(13);
        onlineUsersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        onlineUsersList.setVisibleRowCount(5);


//        onlineUsersArea = new JTextArea(15, 10);
//        onlineUsersArea.setLineWrap(true);
//        onlineUsersArea.setWrapStyleWord(true);
//        onlineUsersArea.setEditable(false);

//        onlineUsersArea.setEditable(false);

        // 发送按钮
        sendButton = new JButton("发送");

        //关闭窗口,退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // 中间面板（包含聊天记录和输入区域）
        JPanel centerPanel = new JPanel(new BorderLayout());

        // 聊天记录区域（带滚动条）
        JScrollPane chatScrollPane = new JScrollPane(chatDisplayArea);
        chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        centerPanel.add(chatScrollPane, BorderLayout.CENTER);

        // 输入区域（带滚动条）
        JPanel inputPanel = new JPanel(new BorderLayout());
        JScrollPane inputScrollPane = new JScrollPane(messageInputArea);
        inputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        // 发送按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(sendButton);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);

        centerPanel.add(inputPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        // 右侧面板（在线用户列表）
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("在线用户"));
        JScrollPane onlineScrollPane = new JScrollPane(onlineUsersList);
        onlineScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rightPanel.add(onlineScrollPane, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }

    private void addEventListeners() {
        // 发送按钮事件
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // 窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (socket != null && !socket.isClosed()) {
                        socket.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void sendMessage() {
        try {
            String message = messageInputArea.getText().trim();
            if (socket == null || socket.isClosed() || !socket.isConnected()) {
                appendMessage("系统: 连接已断开，无法发送消息");
                return;
            }
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(2);
            dos.writeUTF(message);
            dos.flush();
            messageInputArea.setText(""); // 清空输入框
            // 检查socket状态


            // 这里可以添加实际发送消息的逻辑



        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void appendMessage(String message) {
        chatDisplayArea.append(message + "\n");
        // 自动滚动到底部
        chatDisplayArea.setCaretPosition(chatDisplayArea.getDocument().getLength());
    }

    private void setupWindow() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 更新在线用户列表的方法
    public void updateOnlineUsers(String[]  users) {
        onlineUsersList.setListData(users);
    }

    // 添加聊天记录的方法
    public void addChatMessage(String message) {
        appendMessage(message);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chatRoom();
            }
        });
    }

}
