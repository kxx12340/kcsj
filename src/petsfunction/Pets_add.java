package petsfunction;

import connect.ConnectDatabase;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pets_add{
    JFrame pets_add=new JFrame();
    public Pets_add(JFrame menu){
        pets_add.setTitle("宠物信息管理");
        pets_add.setSize(680,450);
        pets_add.setLocationRelativeTo(null);
        pets_add.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_add.setResizable(false);
        pets_add.setLayout(null);
        init(menu);
        pets_add.setVisible(true);
    }
    public void init(JFrame menu){

        JLabel jLabel1=new JLabel("宠物编号:");
        jLabel1.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel1.setBounds(30,0,100,40);
        pets_add.add(jLabel1);
        JTextField idField=new JTextField();
        idField.setFont(new Font("黑体",Font.PLAIN,18));
        idField.setBounds(130,5,500,30);
        pets_add.add(idField);

        JLabel jLabel2=new JLabel("宠物姓名:");
        jLabel2.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel2.setBounds(30,40,100,40);
        pets_add.add(jLabel2);
        JTextField nameField=new JTextField();
        nameField.setFont(new Font("黑体",Font.PLAIN,18));
        nameField.setBounds(130,45,500,30);
        pets_add.add(nameField);

        JLabel jLabel3=new JLabel("宠物年龄:");
        jLabel3.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel3.setBounds(30,80,100,40);
        pets_add.add(jLabel3);
        JTextField ageField=new JTextField();
        ageField.setFont(new Font("黑体",Font.PLAIN,18));
        ageField.setBounds(130,85,500,30);
        pets_add.add(ageField);

        JLabel jLabel4=new JLabel("宠物颜色:");
        jLabel4.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel4.setBounds(30,120,100,40);
        pets_add.add(jLabel4);
        JTextField colorField=new JTextField();
        colorField.setFont(new Font("黑体",Font.PLAIN,18));
        colorField.setBounds(130,125,500,30);
        pets_add.add(colorField);

        JLabel jLabel5=new JLabel("宠物种族:");
        jLabel5.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel5.setBounds(30,160,100,40);
        pets_add.add(jLabel5);
        JTextField raceField=new JTextField();
        raceField.setFont(new Font("黑体",Font.PLAIN,18));
        raceField.setBounds(130,165,500,30);
        pets_add.add(raceField);

        JLabel jLabel6=new JLabel("宠物价格:");
        jLabel6.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel6.setBounds(30,200,100,40);
        pets_add.add(jLabel6);
        JTextField priceField=new JTextField();
        priceField.setFont(new Font("黑体",Font.PLAIN,18));
        priceField.setBounds(130,205,500,30);
        pets_add.add(priceField);

        JLabel jLabel7=new JLabel("销售状态:");
        jLabel7.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel7.setBounds(30,240,100,40);
        pets_add.add(jLabel7);
        JTextField Sales_statusField=new JTextField();
        Sales_statusField.setFont(new Font("黑体",Font.PLAIN,18));
        Sales_statusField.setBounds(130,245,500,30);
        pets_add.add(Sales_statusField);

        JButton btnadd=new JButton("添加");
        btnadd.setFont(new Font("黑体",Font.PLAIN,20));
        btnadd.setBackground(Color.CYAN);
        btnadd.setBounds(200,300,100,50);
        pets_add.add(btnadd);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(400,300,100,50);
        pets_add.add(btnback);

        btnadd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idField.getText();
                String name=nameField.getText();
                String age=ageField.getText();
                String color=colorField.getText();
                String race=raceField.getText();
                String price=priceField.getText();
                String Sales_status2=Sales_statusField.getText();

                String sql="insert into Pets value(?,?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = ConnectDatabase.connection().prepareStatement(sql);
                    ResultSet rs = null;
                    ps.setObject(1, id);
                    ps.setObject(2, name);
                    ps.setObject(3, age);
                    ps.setObject(4, color);
                    ps.setObject(5, race);
                    ps.setObject(6, price);
                    ps.setObject(7, Sales_status2);

                    ps.executeUpdate();

                    ps = ConnectDatabase.connection().prepareStatement("select * from Pets where id=?");
                    ps.setObject(1, id);
                    rs = ps.executeQuery();

                    if (rs != null) {
                        JOptionPane.showMessageDialog(pets_add, "插入成功！");
                    } else {
                        JOptionPane.showMessageDialog(pets_add, "插入失败！");
                    }

                    pets_add.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_add.dispose();
            }
        });
    }
}
