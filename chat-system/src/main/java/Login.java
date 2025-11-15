// Login.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Login extends JFrame {
    private JTextField nicknameField;
    private JButton enterButton;
    private JButton cancelButton;
    private Socket socket;

    public Login() {
        initializeComponents();
        setupLayout();
        addEventListeners();
        setupWindow();
    }

    private void initializeComponents() {
        setTitle("局域网聊天系统");
        nicknameField = new JTextField(15);
        enterButton = new JButton("进入");
        cancelButton = new JButton("取消");
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 昵称标签
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("昵称:"), gbc);

        // 输入框
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(nicknameField, gbc);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    private void addEventListeners() {
        // 进入按钮事件
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handleEnter();
                    //启动聊天界面
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 取消按钮事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancel();
            }
        });

        // 窗口关闭事件
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void handleEnter() throws Exception {
        String nickname = nicknameField.getText().trim();
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入昵称", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //发送登陆消息给服务器端
        socket=new Socket(Constant.ServerIP,Constant.Port);
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1);
        dos.writeUTF(nickname);
        dos.flush();

        // 这里可以添加进入聊天室的逻辑
        JOptionPane.showMessageDialog(this, "欢迎 " + nickname + " 进入聊天室！", "提示", JOptionPane.INFORMATION_MESSAGE);
        // 隐藏当前窗口，打开聊天窗口
        setVisible(false);
        new chatRoom(nickname,socket);
        dispose();
        // TODO: 打开主聊天窗口
    }

    private void handleCancel() {
        int option = JOptionPane.showConfirmDialog(this, "确定要退出吗？", "确认", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void setupWindow() {
        setSize(300, 150);
        setLocationRelativeTo(null); // 居中显示
        setResizable(false);
        setVisible(true);
    }



}
