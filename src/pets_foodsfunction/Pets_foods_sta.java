package pets_foodsfunction;

import connect.ConnectDatabase;
import entity.Pets;
import entity.Pets_foods;
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

public class Pets_foods_sta {
    JFrame pets_foods_sta =new JFrame();
    public Pets_foods_sta(JFrame menu) throws SQLException, InterruptedException {
        pets_foods_sta.setTitle("销售信息");
        pets_foods_sta.setSize(680,600);
        pets_foods_sta.setLocationRelativeTo(null);
        pets_foods_sta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_foods_sta.setResizable(false);
        pets_foods_sta.setLayout(null);
        init(menu);
        pets_foods_sta.setVisible(true);
    }
    public void init(JFrame menu) throws SQLException, InterruptedException {
        String sql="select * from Pets_foods where Sales_status=1";
        PreparedStatement ps= ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);
        List<Pets_foods> list= new ArrayList<>();

        while(rs.next()){
            int id= (int) rs.getObject("id");
            String  name= (String) rs.getObject("name");
            String flavor= (String) rs.getObject("flavor");
            String type= (String) rs.getObject("type");
            int price= (int) rs.getObject("price");
            int Sales_status= (int) rs.getObject("Sales_status");

            Pets_foods pets_foods=new Pets_foods(id,name,flavor,type,price,Sales_status);

            list.add(pets_foods);
        }
        ps.close();
        rs.close();
        String [] ts={"编号","姓名","味道","类型","价格","销售状态"};
        Object[][] data=new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            Pets_foods pets_foods=list.get(i);
            data[i][0]=pets_foods.getId();
            data[i][1]=pets_foods.getName();
            data[i][2]=pets_foods.getFlavor();
            data[i][3]=pets_foods.getType();
            data[i][4]=pets_foods.getPrice();
            data[i][5]=pets_foods.getSales_status();
        }

        DefaultTableModel model=new DefaultTableModel(data,ts);
        JTable table=new JTable(model);

        JScrollPane scrollPane=new JScrollPane(table);

        JPanel panel=new JPanel();
        panel.add(scrollPane);
        pets_foods_sta.add(panel);
        panel.setBounds(0,60,680,450);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        JPanel panel1=new JPanel();
        panel1.add(btnback);
        panel1.setBounds(580,0,80,50);
        pets_foods_sta.add(panel1);

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_foods_sta.dispose();
            }
        });
    }
}