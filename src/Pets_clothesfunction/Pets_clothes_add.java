package Pets_clothesfunction;

import connect.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pets_clothes_add{
    JFrame pets_clothes_add =new JFrame();
    public Pets_clothes_add(JFrame menu){
        pets_clothes_add.setTitle("宠物信息管理");
        pets_clothes_add.setSize(680,450);
        pets_clothes_add.setLocationRelativeTo(null);
        pets_clothes_add.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_clothes_add.setResizable(false);
        pets_clothes_add.setLayout(null);
        init(menu);
        pets_clothes_add.setVisible(true);
    }
    public void init(JFrame menu){

        JLabel jLabel1=new JLabel("衣服编号:");
        jLabel1.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel1.setBounds(30,0,100,40);
        pets_clothes_add.add(jLabel1);
        JTextField idField=new JTextField();
        idField.setFont(new Font("黑体",Font.PLAIN,18));
        idField.setBounds(130,5,500,30);
        pets_clothes_add.add(idField);

        JLabel jLabel2=new JLabel("衣服类型:");
        jLabel2.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel2.setBounds(30,40,100,40);
        pets_clothes_add.add(jLabel2);
        JTextField styleField=new JTextField();
        styleField.setFont(new Font("黑体",Font.PLAIN,18));
        styleField.setBounds(130,45,500,30);
        pets_clothes_add.add(styleField);

        JLabel jLabel3=new JLabel("衣服尺寸:");
        jLabel3.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel3.setBounds(30,80,100,40);
        pets_clothes_add.add(jLabel3);
        JTextField sizeField=new JTextField();
        sizeField.setFont(new Font("黑体",Font.PLAIN,18));
        sizeField.setBounds(130,85,500,30);
        pets_clothes_add.add(sizeField);

        JLabel jLabel4=new JLabel("衣服颜色:");
        jLabel4.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel4.setBounds(30,120,100,40);
        pets_clothes_add.add(jLabel4);
        JTextField colorField=new JTextField();
        colorField.setFont(new Font("黑体",Font.PLAIN,18));
        colorField.setBounds(130,125,500,30);
        pets_clothes_add.add(colorField);

        JLabel jLabel5=new JLabel("衣服价格:");
        jLabel5.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel5.setBounds(30,160,100,40);
        pets_clothes_add.add(jLabel5);
        JTextField priceField=new JTextField();
        priceField.setFont(new Font("黑体",Font.PLAIN,18));
        priceField.setBounds(130,165,500,30);
        pets_clothes_add.add(priceField);

        JLabel jLabel6=new JLabel("销售状态:");
        jLabel6.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel6.setBounds(30,200,100,40);
        pets_clothes_add.add(jLabel6);
        JTextField Sales_statusField=new JTextField();
        Sales_statusField.setFont(new Font("黑体",Font.PLAIN,18));
        Sales_statusField.setBounds(130,205,500,30);
        pets_clothes_add.add(Sales_statusField);


        JButton btnadd=new JButton("添加");
        btnadd.setFont(new Font("黑体",Font.PLAIN,20));
        btnadd.setBackground(Color.CYAN);
        btnadd.setBounds(200,300,100,50);
        pets_clothes_add.add(btnadd);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(400,300,100,50);
        pets_clothes_add.add(btnback);

        btnadd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idField.getText();
                String style=styleField.getText();
                String size=sizeField.getText();
                String color=colorField.getText();
                String price=priceField.getText();
                String Sales_status=Sales_statusField.getText();

                String sql="insert into Pets_clothes value(?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = ConnectDatabase.connection().prepareStatement(sql);
                    ResultSet rs = null;
                    ps.setObject(1, id);
                    ps.setObject(2, style);
                    ps.setObject(3, size);
                    ps.setObject(4, color);
                    ps.setObject(5, price);
                    ps.setObject(6, Sales_status);
                    ps.executeUpdate();

                    ps = ConnectDatabase.connection().prepareStatement("select * from Pets_clothes where id=?");
                    ps.setObject(1, id);
                    rs = ps.executeQuery();

                    if (rs != null) {
                        JOptionPane.showMessageDialog(pets_clothes_add, "插入成功！");
                    } else {
                        JOptionPane.showMessageDialog(pets_clothes_add, "插入失败！");
                    }

                    pets_clothes_add.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_clothes_add.dispose();
            }
        });
    }
}
