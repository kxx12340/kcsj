package Log_in;

import connect.count_database;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class Log_in {
    JFrame Log_in =new JFrame("宠物店管理系统");
    public Log_in() throws SQLException,ClassNotFoundException{
        Log_in.setTitle("登录");
        Log_in.setSize(900,500);
        Log_in.setLocationRelativeTo(null);//使窗口出现在中间位置
        Log_in.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗口关闭的方式
        Log_in.setResizable(false);//调整窗口大小
        Log_in.setLayout(null);
        init();
        Log_in.setVisible(true);
    }
    public void init() throws SQLException,ClassNotFoundException {
        JLabel Log_inText=new JLabel("宠物店管理系统");
        Log_inText.setFont(new Font("黑体",Font.PLAIN,50));
        Log_inText.setBounds(280,2,800,100);
        Log_in.add(Log_inText);

        JLabel UsernameText=new JLabel("用户名");
        UsernameText.setFont(new Font("黑体",Font.PLAIN,30));
        UsernameText.setBounds(200,140,200,100);
        Log_in.add(UsernameText);

        JTextField UserName=new JTextField();
        UserName.setFont(new Font("黑体",Font.PLAIN,18));
        UserName.setBounds(330,170,280,40);
        Log_in.add(UserName);

        JLabel passwordText=new JLabel("密码");
        passwordText.setFont(new Font("黑体",Font.PLAIN,30));
        passwordText.setBounds(200,200,200,100);
        Log_in.add(passwordText);

        JPasswordField Password=new JPasswordField();
        Password.setBounds(330,230,280,40);
        Log_in.add(Password);

        JButton btnLogin=new JButton("登录");
        btnLogin.setFont(new Font("黑体",Font.PLAIN,20));
        btnLogin.setBounds(250,330,100,50);
        btnLogin.setBackground(Color.CYAN);
        Log_in.add(btnLogin);

        JButton btnSignup=new JButton("注册");
        btnSignup.setFont(new Font("黑体",Font.PLAIN,20));
        btnSignup.setBounds(550,330,100,50);
        btnSignup.setBackground(Color.CYAN);
        Log_in.add(btnSignup);

        btnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=UserName.getText();
                String password=new String(Password.getPassword());
                int count=0;
                try {
                    count= count_database.checkAccount(username,password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if(count>0){
                    JOptionPane.showMessageDialog(Log_in,"登录成功！");
                    try {
                        new Menu();
                        Log_in.dispose();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Log_in.dispose();
                }else {
                    JOptionPane.showMessageDialog(Log_in,"登录失败！\n请检查你的账号密码！");
                    UserName.setText("");
                    Password.setText("");
                }
            }
        });
        btnSignup.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sign_up();
                Log_in.dispose();
            }
        });
    }
}
