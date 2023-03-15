package Pets_clothesfunction;

import connect.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pets_clothes_update {
    JFrame pets_clothes_update =new JFrame();
    public Pets_clothes_update(JFrame menu){
        pets_clothes_update.setTitle("宠物信息管理");
        pets_clothes_update.setSize(680,600);
        pets_clothes_update.setLocationRelativeTo(null);
        pets_clothes_update.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_clothes_update.setResizable(false);
        pets_clothes_update.setLayout(null);
        init(menu);
        pets_clothes_update.setVisible(true);
    }
    public void init(JFrame menu){
        JLabel label=new JLabel("请输入需要修改的编号:");
        label.setFont(new Font("黑体",Font.PLAIN,20));
        label.setBounds(200,0,400,40);
        pets_clothes_update.add(label);
        JTextField textField=new JTextField();
        textField.setFont(new Font("黑体",Font.PLAIN,18));
        textField.setBounds(200,40,200,40);
        pets_clothes_update.add(textField);

        JLabel jLabel1=new JLabel("衣服编号:");
        jLabel1.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel1.setBounds(30,100,100,40);
        pets_clothes_update.add(jLabel1);
        JTextField idField=new JTextField();
        idField.setFont(new Font("黑体",Font.PLAIN,18));
        idField.setBounds(130,105,500,30);
        pets_clothes_update.add(idField);

        JLabel jLabel2=new JLabel("衣服类型:");
        jLabel2.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel2.setBounds(30,140,100,40);
        pets_clothes_update.add(jLabel2);
        JTextField styleField=new JTextField();
        styleField.setFont(new Font("黑体",Font.PLAIN,18));
        styleField.setBounds(130,145,500,30);
        pets_clothes_update.add(styleField);

        JLabel jLabel3=new JLabel("衣服尺寸:");
        jLabel3.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel3.setBounds(30,180,100,40);
        pets_clothes_update.add(jLabel3);
        JTextField sizeField=new JTextField();
        sizeField.setFont(new Font("黑体",Font.PLAIN,18));
        sizeField.setBounds(130,185,500,30);
        pets_clothes_update.add(sizeField);

        JLabel jLabel4=new JLabel("衣服颜色:");
        jLabel4.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel4.setBounds(30,220,100,40);
        pets_clothes_update.add(jLabel4);
        JTextField colorField=new JTextField();
        colorField.setFont(new Font("黑体",Font.PLAIN,18));
        colorField.setBounds(130,225,500,30);
        pets_clothes_update.add(colorField);

        JLabel jLabel5=new JLabel("衣服价格:");
        jLabel5.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel5.setBounds(30,260,100,40);
        pets_clothes_update.add(jLabel5);
        JTextField peiceField=new JTextField();
        peiceField.setFont(new Font("黑体",Font.PLAIN,18));
        peiceField.setBounds(130,265,500,30);
        pets_clothes_update.add(peiceField);

        JLabel jLabel6=new JLabel("销售状态:");
        jLabel6.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel6.setBounds(30,300,100,40);
        pets_clothes_update.add(jLabel6);
        JTextField Sales_statusField=new JTextField();
        Sales_statusField.setFont(new Font("黑体",Font.PLAIN,18));
        Sales_statusField.setBounds(130,305,500,30);
        pets_clothes_update.add(Sales_statusField);

        JButton btnupdate=new JButton("修改");
        btnupdate.setFont(new Font("黑体",Font.PLAIN,20));
        btnupdate.setBackground(Color.CYAN);
        btnupdate.setBounds(200,400,100,50);
        pets_clothes_update.add(btnupdate);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(400,400,100,50);
        pets_clothes_update.add(btnback);


        btnupdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idField.getText();
                String style=styleField.getText();
                String size=sizeField.getText();
                String color=colorField.getText();
                String price=peiceField.getText();
                String Sales_status=Sales_statusField.getText();

                String pid=textField.getText();
                int pid2=Integer.valueOf(pid);

                String sql="update Pets_clothes set id=?, style=?, size=?,color=?,price=?,Sales_status=?  where id=?";
                try {
                    PreparedStatement ps = ConnectDatabase.connection().prepareStatement(sql);
                    ResultSet rs=null;
                    ps.setObject(1, id);
                    ps.setObject(2, style);
                    ps.setObject(3, size);
                    ps.setObject(4, color);
                    ps.setObject(5, price);
                    ps.setObject(6, Sales_status);

                    ps.setInt(7,pid2);

                    ps.executeUpdate();

                    int i=ps.executeUpdate();
                    if(i>0){
                        JOptionPane.showMessageDialog(pets_clothes_update,"修改失败!");
                        pets_clothes_update.dispose();
                    }else {
                        JOptionPane.showMessageDialog(pets_clothes_update,"修改成功!");
                        pets_clothes_update.dispose();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_clothes_update.dispose();
            }
        });
    }
}