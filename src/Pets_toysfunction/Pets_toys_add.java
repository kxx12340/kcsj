package Pets_toysfunction;

import connect.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pets_toys_add{
    JFrame pets_toys_add =new JFrame();
    public Pets_toys_add(JFrame menu){
        pets_toys_add.setTitle("宠物信息管理");
        pets_toys_add.setSize(680,450);
        pets_toys_add.setLocationRelativeTo(null);
        pets_toys_add.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_toys_add.setResizable(false);
        pets_toys_add.setLayout(null);
        init(menu);
        pets_toys_add.setVisible(true);
    }
    public void init(JFrame menu){

        JLabel jLabel1=new JLabel("玩具编号:");
        jLabel1.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel1.setBounds(30,0,100,40);
        pets_toys_add.add(jLabel1);
        JTextField idField=new JTextField();
        idField.setFont(new Font("黑体",Font.PLAIN,18));
        idField.setBounds(130,5,500,30);
        pets_toys_add.add(idField);

        JLabel jLabel2=new JLabel("玩具类型:");
        jLabel2.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel2.setBounds(30,40,100,40);
        pets_toys_add.add(jLabel2);
        JTextField typeField=new JTextField();
        typeField.setFont(new Font("黑体",Font.PLAIN,18));
        typeField.setBounds(130,45,500,30);
        pets_toys_add.add(typeField);

        JLabel jLabel3=new JLabel("玩具颜色:");
        jLabel3.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel3.setBounds(30,80,100,40);
        pets_toys_add.add(jLabel3);
        JTextField colorField=new JTextField();
        colorField.setFont(new Font("黑体",Font.PLAIN,18));
        colorField.setBounds(130,85,500,30);
        pets_toys_add.add(colorField);

        JLabel jLabel4=new JLabel("玩具价格:");
        jLabel4.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel4.setBounds(30,120,100,40);
        pets_toys_add.add(jLabel4);
        JTextField priceField=new JTextField();
        priceField.setFont(new Font("黑体",Font.PLAIN,18));
        priceField.setBounds(130,125,500,30);
        pets_toys_add.add(priceField);

        JLabel jLabel5=new JLabel("销售状态:");
        jLabel5.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel5.setBounds(30,160,100,40);
        pets_toys_add.add(jLabel5);
        JTextField Sales_statusField=new JTextField();
        Sales_statusField.setFont(new Font("黑体",Font.PLAIN,18));
        Sales_statusField.setBounds(130,165,500,30);
        pets_toys_add.add(Sales_statusField);


        JButton btnadd=new JButton("添加");
        btnadd.setFont(new Font("黑体",Font.PLAIN,20));
        btnadd.setBackground(Color.CYAN);
        btnadd.setBounds(200,300,100,50);
        pets_toys_add.add(btnadd);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(400,300,100,50);
        pets_toys_add.add(btnback);

        btnadd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idField.getText();
                String type=typeField.getText();
                String color=colorField.getText();
                String price=priceField.getText();
                String Sales_status=Sales_statusField.getText();

                String sql="insert into Pets_toys value(?,?,?,?,?)";
                try {
                    PreparedStatement ps = ConnectDatabase.connection().prepareStatement(sql);
                    ResultSet rs = null;
                    ps.setObject(1, id);
                    ps.setObject(2, type);
                    ps.setObject(3, color);
                    ps.setObject(4, price);
                    ps.setObject(5, Sales_status);
                    ps.executeUpdate();

                    ps = ConnectDatabase.connection().prepareStatement("select * from Pets_toys where id=?");
                    ps.setObject(1, id);
                    rs = ps.executeQuery();

                    if (rs != null) {
                        JOptionPane.showMessageDialog(pets_toys_add, "插入成功！");
                    } else {
                        JOptionPane.showMessageDialog(pets_toys_add, "插入失败！");
                    }

                    pets_toys_add.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_toys_add.dispose();
            }
        });
    }
}
