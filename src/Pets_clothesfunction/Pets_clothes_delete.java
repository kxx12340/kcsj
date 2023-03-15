package Pets_clothesfunction;

import connect.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pets_clothes_delete {
    JFrame pets_clothes_delete =new JFrame();
    public Pets_clothes_delete(JFrame menu){
        pets_clothes_delete.setTitle("宠物信息管理");
        pets_clothes_delete.setSize(400,300);
        pets_clothes_delete.setLocationRelativeTo(null);
        pets_clothes_delete.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_clothes_delete.setResizable(false);
        pets_clothes_delete.setLayout(null);
        init(menu);
        pets_clothes_delete.setVisible(true);
    }
    public void init(JFrame menu){
        JLabel label1=new JLabel("请输入需要删除的编号(id):");
        label1.setFont(new Font("黑体", Font.PLAIN,20));
        label1.setBounds(30,30,300,30);
        pets_clothes_delete.add(label1);

        JTextField textField1=new JTextField();
        textField1.setFont(new Font("黑体", Font.PLAIN,20));
        textField1.setBounds(30,100,300,30);
        pets_clothes_delete.add(textField1);

        JButton btndelete=new JButton("删除");
        btndelete.setFont(new Font("黑体",Font.PLAIN,20));
        btndelete.setBackground(Color.CYAN);
        btndelete.setBounds(30,200,100,50);
        pets_clothes_delete.add(btndelete);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(230,200,100,50);
        pets_clothes_delete.add(btnback);

        btndelete.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid=textField1.getText();
                if(!pid.equals("")){
                    int id=Integer.valueOf(pid);
                    String sql="delete from Pets_clothes where id=?";
                    try {
                        PreparedStatement ps= ConnectDatabase.connection().prepareStatement(sql);
                        ps.setObject(1,id);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(pets_clothes_delete,"删除成功!");
                        ps.close();
                        pets_clothes_delete.dispose();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(pets_clothes_delete,"删除失败!");
                }
            }
        });

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_clothes_delete.dispose();
            }
        });
    }
}
