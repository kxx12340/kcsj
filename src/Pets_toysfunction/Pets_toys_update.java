package Pets_toysfunction;

import connect.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pets_toys_update {
    JFrame pets_toys_update =new JFrame();
    public Pets_toys_update(JFrame menu){
        pets_toys_update.setTitle("宠物信息管理");
        pets_toys_update.setSize(680,600);
        pets_toys_update.setLocationRelativeTo(null);
        pets_toys_update.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_toys_update.setResizable(false);
        pets_toys_update.setLayout(null);
        init(menu);
        pets_toys_update.setVisible(true);
    }
    public void init(JFrame menu){
        JLabel label=new JLabel("请输入需要修改的编号:");
        label.setFont(new Font("黑体",Font.PLAIN,20));
        label.setBounds(200,0,400,40);
        pets_toys_update.add(label);
        JTextField textField=new JTextField();
        textField.setFont(new Font("黑体",Font.PLAIN,18));
        textField.setBounds(200,40,200,40);
        pets_toys_update.add(textField);

        JLabel jLabel1=new JLabel("玩具编号:");
        jLabel1.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel1.setBounds(30,100,100,40);
        pets_toys_update.add(jLabel1);
        JTextField idField=new JTextField();
        idField.setFont(new Font("黑体",Font.PLAIN,18));
        idField.setBounds(130,105,500,30);
        pets_toys_update.add(idField);

        JLabel jLabel2=new JLabel("玩具类型:");
        jLabel2.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel2.setBounds(30,140,100,40);
        pets_toys_update.add(jLabel2);
        JTextField typeField=new JTextField();
        typeField.setFont(new Font("黑体",Font.PLAIN,18));
        typeField.setBounds(130,145,500,30);
        pets_toys_update.add(typeField);

        JLabel jLabel3=new JLabel("玩具颜色:");
        jLabel3.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel3.setBounds(30,180,100,40);
        pets_toys_update.add(jLabel3);
        JTextField colorField=new JTextField();
        colorField.setFont(new Font("黑体",Font.PLAIN,18));
        colorField.setBounds(130,185,500,30);
        pets_toys_update.add(colorField);

        JLabel jLabel4=new JLabel("玩具价格:");
        jLabel4.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel4.setBounds(30,220,100,40);
        pets_toys_update.add(jLabel4);
        JTextField priceField=new JTextField();
        priceField.setFont(new Font("黑体",Font.PLAIN,18));
        priceField.setBounds(130,225,500,30);
        pets_toys_update.add(priceField);

        JLabel jLabel5=new JLabel("销售状态:");
        jLabel5.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel5.setBounds(30,260,100,40);
        pets_toys_update.add(jLabel5);
        JTextField Sales_statusField=new JTextField();
        Sales_statusField.setFont(new Font("黑体",Font.PLAIN,18));
        Sales_statusField.setBounds(130,265,500,30);
        pets_toys_update.add(Sales_statusField);

        JButton btnupdate=new JButton("修改");
        btnupdate.setFont(new Font("黑体",Font.PLAIN,20));
        btnupdate.setBackground(Color.CYAN);
        btnupdate.setBounds(200,400,100,50);
        pets_toys_update.add(btnupdate);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(400,400,100,50);
        pets_toys_update.add(btnback);


        btnupdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idField.getText();
                String type=typeField.getText();
                String color=priceField.getText();
                String price=priceField.getText();
                String Sales_status=Sales_statusField.getText();

                String pid=textField.getText();
                int pid2=Integer.valueOf(pid);

                String sql="update Pets_toys set id=?, type=?, color=?,price=?,Sales_status=?  where id=?";
                try {
                    PreparedStatement ps = ConnectDatabase.connection().prepareStatement(sql);
                    ResultSet rs=null;
                    ps.setObject(1, id);
                    ps.setObject(2, type);
                    ps.setObject(3, color);
                    ps.setObject(4, price);
                    ps.setObject(5, Sales_status);

                    ps.setInt(6,pid2);

                    ps.executeUpdate();

                    int i=ps.executeUpdate();
                    if(i>0){
                        JOptionPane.showMessageDialog(pets_toys_update,"修改失败!");
                        pets_toys_update.dispose();
                    }else {
                        JOptionPane.showMessageDialog(pets_toys_update,"修改成功!");
                        pets_toys_update.dispose();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_toys_update.dispose();
            }
        });
    }
}