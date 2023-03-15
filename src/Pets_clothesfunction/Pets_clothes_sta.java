package Pets_clothesfunction;

import connect.ConnectDatabase;
import entity.Pets_clothes;
import entity.Pets_foods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_clothes_sta {
    JFrame pets_clothes_sta =new JFrame();
    public Pets_clothes_sta(JFrame menu) throws SQLException, InterruptedException {
        pets_clothes_sta.setTitle("销售信息");
        pets_clothes_sta.setSize(680,600);
        pets_clothes_sta.setLocationRelativeTo(null);
        pets_clothes_sta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_clothes_sta.setResizable(false);
        pets_clothes_sta.setLayout(null);
        init(menu);
        pets_clothes_sta.setVisible(true);
    }
    public void init(JFrame menu) throws SQLException, InterruptedException {
        String sql="select * from Pets_clothes where Sales_status=1";
        PreparedStatement ps= ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);
        List<Pets_clothes> list= new ArrayList<>();

        while(rs.next()){
            int id= (int) rs.getObject("id");
            String  style= (String) rs.getObject("style");
            String size= (String) rs.getObject("size");
            String color= (String) rs.getObject("color");
            int price= (int) rs.getObject("price");
            int Sales_status= (int) rs.getObject("Sales_status");

            Pets_clothes pets_clothes=new Pets_clothes(id,style,size,color,price,Sales_status);

            list.add(pets_clothes);
        }
        ps.close();
        rs.close();
        String [] ts={"编号","类型","尺寸","颜色","价格","销售状态"};
        Object[][] data=new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            Pets_clothes pets_foods=list.get(i);
            data[i][0]=pets_foods.getId();
            data[i][1]=pets_foods.getStyle();
            data[i][2]=pets_foods.getSize();
            data[i][3]=pets_foods.getColor();
            data[i][4]=pets_foods.getPrice();
            data[i][5]=pets_foods.getSales_status();
        }

        DefaultTableModel model=new DefaultTableModel(data,ts);
        JTable table=new JTable(model);

        JScrollPane scrollPane=new JScrollPane(table);

        JPanel panel=new JPanel();
        panel.add(scrollPane);
        pets_clothes_sta.add(panel);
        panel.setBounds(0,60,680,450);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        JPanel panel1=new JPanel();
        panel1.add(btnback);
        panel1.setBounds(580,0,80,50);
        pets_clothes_sta.add(panel1);

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_clothes_sta.dispose();
            }
        });
    }
}