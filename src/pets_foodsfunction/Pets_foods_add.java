package pets_foodsfunction;

import connect.ConnectDatabase;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pets_foods_add{
    JFrame pets_foods_add =new JFrame();
    public Pets_foods_add(JFrame menu){
        pets_foods_add.setTitle("宠物信息管理");
        pets_foods_add.setSize(680,450);
        pets_foods_add.setLocationRelativeTo(null);
        pets_foods_add.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_foods_add.setResizable(false);
        pets_foods_add.setLayout(null);
        init(menu);
        pets_foods_add.setVisible(true);
    }
    public void init(JFrame menu){

        JLabel jLabel1=new JLabel("食品编号:");
        jLabel1.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel1.setBounds(30,0,100,40);
        pets_foods_add.add(jLabel1);
        JTextField idField=new JTextField();
        idField.setFont(new Font("黑体",Font.PLAIN,18));
        idField.setBounds(130,5,500,30);
        pets_foods_add.add(idField);

        JLabel jLabel2=new JLabel("品牌名字:");
        jLabel2.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel2.setBounds(30,40,100,40);
        pets_foods_add.add(jLabel2);
        JTextField nameField=new JTextField();
        nameField.setFont(new Font("黑体",Font.PLAIN,18));
        nameField.setBounds(130,45,500,30);
        pets_foods_add.add(nameField);

        JLabel jLabel3=new JLabel("食品味道:");
        jLabel3.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel3.setBounds(30,80,100,40);
        pets_foods_add.add(jLabel3);
        JTextField flavorField=new JTextField();
        flavorField.setFont(new Font("黑体",Font.PLAIN,18));
        flavorField.setBounds(130,85,500,30);
        pets_foods_add.add(flavorField);

        JLabel jLabel4=new JLabel("食品类型:");
        jLabel4.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel4.setBounds(30,120,100,40);
        pets_foods_add.add(jLabel4);
        JTextField typeField=new JTextField();
        typeField.setFont(new Font("黑体",Font.PLAIN,18));
        typeField.setBounds(130,125,500,30);
        pets_foods_add.add(typeField);

        JLabel jLabel5=new JLabel("食品价格:");
        jLabel5.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel5.setBounds(30,160,100,40);
        pets_foods_add.add(jLabel5);
        JTextField peiceField=new JTextField();
        peiceField.setFont(new Font("黑体",Font.PLAIN,18));
        peiceField.setBounds(130,165,500,30);
        pets_foods_add.add(peiceField);

        JLabel jLabel6=new JLabel("销售状态:");
        jLabel6.setFont(new Font("黑体",Font.PLAIN,20));
        jLabel6.setBounds(30,200,100,40);
        pets_foods_add.add(jLabel6);
        JTextField Sales_statusField=new JTextField();
        Sales_statusField.setFont(new Font("黑体",Font.PLAIN,18));
        Sales_statusField.setBounds(130,205,500,30);
        pets_foods_add.add(Sales_statusField);

        JButton btnadd=new JButton("添加");
        btnadd.setFont(new Font("黑体",Font.PLAIN,20));
        btnadd.setBackground(Color.CYAN);
        btnadd.setBounds(200,300,100,50);
        pets_foods_add.add(btnadd);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(400,300,100,50);
        pets_foods_add.add(btnback);

        btnadd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idField.getText();
                String name=nameField.getText();
                String flavor=flavorField.getText();
                String type=typeField.getText();
                String price=peiceField.getText();
                String Sales_status2=Sales_statusField.getText();

                String sql="insert into Pets_foods value(?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = ConnectDatabase.connection().prepareStatement(sql);
                    ResultSet rs = null;
                    ps.setObject(1, id);
                    ps.setObject(2, name);
                    ps.setObject(3, flavor);
                    ps.setObject(4, type);
                    ps.setObject(5, price);
                    ps.setObject(6, Sales_status2);

                    ps.executeUpdate();

                    ps = ConnectDatabase.connection().prepareStatement("select * from Pets_foods where id=?");
                    ps.setObject(1, id);
                    rs = ps.executeQuery();

                    if (rs != null) {
                        JOptionPane.showMessageDialog(pets_foods_add, "插入成功！");
                    } else {
                        JOptionPane.showMessageDialog(pets_foods_add, "插入失败！");
                    }

                    pets_foods_add.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_foods_add.dispose();
            }
        });
    }
}
