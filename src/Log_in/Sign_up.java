package Log_in;

import connect.ConnectDatabase;
import connect.count_database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sign_up {
    JFrame sign_up =new JFrame("注册");
    public Sign_up(){
        sign_up.setTitle("注册");
        sign_up.setSize(900,500);
        sign_up.setLocationRelativeTo(null);
        sign_up.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sign_up.setResizable(false);
        sign_up.setLayout(null);
        init();
        sign_up.setVisible(true);
    }
    public void init() {
        JLabel sign_upText=new JLabel("请注册你的账号");
        sign_upText.setFont(new Font("黑体",Font.PLAIN,32));
        sign_upText.setBounds(280,2,400,100);
        sign_up.add(sign_upText);

        JLabel UsernameText=new JLabel("用户名");
        UsernameText.setFont(new Font("黑体",Font.PLAIN,30));
        UsernameText.setBounds(200,140,200,100);
        sign_up.add(UsernameText);

        JTextField UserName=new JTextField();
        UserName.setFont(new Font("黑体",Font.PLAIN,18));
        UserName.setBounds(330,170,280,40);
        sign_up.add(UserName);

        JLabel passwordText=new JLabel("密码");
        passwordText.setFont(new Font("黑体",Font.PLAIN,30));
        passwordText.setBounds(200,200,200,100);
        sign_up.add(passwordText);

        JPasswordField Password=new JPasswordField();
        Password.setBounds(330,230,280,40);
        sign_up.add(Password);

        JButton btn_Sign_up=new JButton("注册");
        btn_Sign_up.setFont(new Font("黑体",Font.PLAIN,20));
        btn_Sign_up.setBounds(250,330,100,50);
        btn_Sign_up.setBackground(Color.cyan);
        sign_up.add(btn_Sign_up);

        JButton btn_Back=new JButton("返回");
        btn_Back.setFont(new Font("黑体",Font.PLAIN,20));
        btn_Back.setBounds(550,330,100,50);
        btn_Back.setBackground(Color.cyan);
        sign_up.add(btn_Back);

        btn_Sign_up.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=UserName.getText();
                String password=new String(Password.getPassword());
                if(!username.equals("")&&!password.equals("")){
                    int count=0;
                    String sql="select * from user where username=? ";
                    try {
                        PreparedStatement st= ConnectDatabase.connection().prepareStatement(sql);
                        st.setString(1,username);
                        ResultSet rs=st.executeQuery();
                        if(!rs.next()){
                            count= count_database.addAccount(username,password);
                            if(count>0){
                                JOptionPane.showMessageDialog(sign_up,"注册成功！");
                                new Log_in();
                                sign_up.dispose();
                            }
                        }else {
                            JOptionPane.showMessageDialog(sign_up,"注册失败！\n该账号已被注册！");
                            UserName.setText("");
                            Password.setText("");
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }else
                    JOptionPane.showMessageDialog(sign_up,"注册失败！\n请按照要求进行输入！");
            }
        });
        btn_Back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Log_in();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    sign_up.dispose();
                }
            }
        });
    }
}
