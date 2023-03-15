package petsfunction;

import connect.ConnectDatabase;
import menu.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Result {
    JFrame result=new JFrame();
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tabledata;
    private TableModel tableModel;
    public Result(String pid,JFrame menu) throws SQLException {
        result.setTitle("查询结果");
        result.setSize(500,450);
        result.setLocationRelativeTo(null);
        result.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        result.setResizable(false);
        result.setLayout(null);
        init(pid,menu);
        result.setVisible(true);
    }
    public void init(String pid,JFrame menu) throws SQLException {
        String [] ts={"编号","姓名","年龄","颜色","种族","价格","销售状态"};
        titles=new Vector<>();
        for(String title:ts){
            titles.add(title);
        }
        tabledata=new Vector<>();
        tableModel=new DefaultTableModel(tabledata,titles);
        table=new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(200,200,100,50);
        result.add(btnback);

        selectresult(pid);
        JScrollPane scrollPane=new JScrollPane(table);
        JPanel panel=new JPanel();
        panel.add(scrollPane);
        result.add(panel);
        panel.setBounds(0,0,500,600);

        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.dispose();
            }
        });
    }
    public void selectresult(String pid) throws SQLException {
        tabledata.clear();
        Vector<Vector> data=selectgetInfo(pid);
        for(Vector vector:data){
            tabledata.add(vector);
        }
    }
    public Vector<Vector> selectgetInfo(String pid) throws SQLException {
        String sql="select * from Pets where id=?";
        Vector<Vector> data=new Vector<>();
        PreparedStatement ps= ConnectDatabase.connection().prepareStatement(sql);
        ps.setString(1,pid);
        ResultSet rs=ps.executeQuery();
        String id,name,age,color,race,price,Sales_status;
        while(rs.next()){
            Vector information=new Vector<String>();
            id=rs.getString("id");
            name=rs.getString("name");
            age=rs.getString("age");
            color=rs.getString("color");
            race=rs.getString("race");
            price=rs.getString("price");
            Sales_status=rs.getString("Sales_status");
            information.add(id);
            information.add(name);
            information.add(age);
            information.add(color);
            information.add(race);
            information.add(price);
            information.add(Sales_status);
            data.add(information);
        }
        ps.close();
        rs.close();
        return data;
    }
}