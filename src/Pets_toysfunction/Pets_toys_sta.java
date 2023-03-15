package Pets_toysfunction;

import connect.ConnectDatabase;
import entity.Pets_clothes;
import entity.Pets_toys;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_toys_sta {
    JFrame pets_toys_sta =new JFrame();
    public Pets_toys_sta(JFrame menu) throws SQLException, InterruptedException {
        pets_toys_sta.setTitle("销售信息");
        pets_toys_sta.setSize(680,600);
        pets_toys_sta.setLocationRelativeTo(null);
        pets_toys_sta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_toys_sta.setResizable(false);
        pets_toys_sta.setLayout(null);
        init(menu);
        pets_toys_sta.setVisible(true);
    }
    public void init(JFrame menu) throws SQLException, InterruptedException {
        String sql="select * from Pets_toys where Sales_status=1";
        PreparedStatement ps= ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);
        List<Pets_toys> list= new ArrayList<>();

        while(rs.next()){
            int id= (int) rs.getObject("id");
            String  type= (String) rs.getObject("type");
            String color= (String) rs.getObject("color");
            int price= (int) rs.getObject("price");
            int Sales_status= (int) rs.getObject("Sales_status");

            Pets_toys pets_toys=new Pets_toys(id,type,color,price,Sales_status);

            list.add(pets_toys);
        }
        ps.close();
        rs.close();
        String [] ts={"编号","类型","颜色","价格","销售状态"};
        Object[][] data=new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Pets_toys pets_toys=list.get(i);
            data[i][0]=pets_toys.getId();
            data[i][1]=pets_toys.getType();
            data[i][2]=pets_toys.getColor();
            data[i][3]=pets_toys.getPrice();
            data[i][4]=pets_toys.getSales_status();
        }

        DefaultTableModel model=new DefaultTableModel(data,ts);
        JTable table=new JTable(model);

        JScrollPane scrollPane=new JScrollPane(table);

        JPanel panel=new JPanel();
        panel.add(scrollPane);
        pets_toys_sta.add(panel);
        panel.setBounds(0,60,680,450);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        JPanel panel1=new JPanel();
        panel1.add(btnback);
        panel1.setBounds(580,0,80,50);
        pets_toys_sta.add(panel1);

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_toys_sta.dispose();
            }
        });
    }
}