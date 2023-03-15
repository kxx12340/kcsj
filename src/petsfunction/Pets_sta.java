package petsfunction;

import connect.ConnectDatabase;
import entity.Pets;
import menu.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_sta {
    JFrame pets_sta=new JFrame();
    public Pets_sta(JFrame menu) throws SQLException, InterruptedException {
        pets_sta.setTitle("销售信息");
        pets_sta.setSize(680,600);
        pets_sta.setLocationRelativeTo(null);
        pets_sta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_sta.setResizable(false);
        pets_sta.setLayout(null);
        init(menu);
        pets_sta.setVisible(true);
    }
    public void init(JFrame menu) throws SQLException, InterruptedException {
        String sql="select * from Pets where Sales_status=1";
        PreparedStatement ps= ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);
        List<Pets> list=new ArrayList<Pets>();

        while(rs.next()){
            int id= (int) rs.getObject("id");
            String  name= (String) rs.getObject("name");
            int age= (int) rs.getObject("age");
            String color= (String) rs.getObject("color");
            String race= (String) rs.getObject("race");
            int price= (int) rs.getObject("price");
            int Sales_status= (int) rs.getObject("Sales_status");

            Pets pets=new Pets(id,name,age,color,race,price,Sales_status);

            list.add(pets);
        }
        ps.close();
        rs.close();
        String [] ts={"编号","姓名","年龄","颜色","种族","价格","销售状态"};
        Object[][] data=new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            Pets pets=list.get(i);
            data[i][0]=pets.getId();
            data[i][1]=pets.getName();
            data[i][2]=pets.getAge();
            data[i][3]=pets.getColor();
            data[i][4]=pets.getRace();
            data[i][5]=pets.getPrice();
            data[i][6]=pets.getSales_status();
        }

        DefaultTableModel model=new DefaultTableModel(data,ts);
        JTable table=new JTable(model);

        JScrollPane scrollPane=new JScrollPane(table);

        JPanel panel=new JPanel();
        panel.add(scrollPane);
        pets_sta.add(panel);
        panel.setBounds(0,60,680,450);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        JPanel panel1=new JPanel();
        panel1.add(btnback);
        panel1.setBounds(580,0,80,50);
        pets_sta.add(panel1);

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_sta.dispose();
            }
        });
    }
}