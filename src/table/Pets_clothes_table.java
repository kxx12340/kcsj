package table;

import Pets_clothesfunction.*;
import connect.ConnectDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Pets_clothes_table extends Box {
    final int width=850;
    final int height=600;
    JFrame menu=null;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tabledata;
    private TableModel tableModel;

    /**
     *        Pets组件
     *
     */
    public Pets_clothes_table(JFrame menu) throws SQLException,ClassNotFoundException {
        //垂直布局
        super(BoxLayout.Y_AXIS);
        this.menu=menu;
        //组装视图
        JPanel btnPanel=new JPanel();
        Color color=new Color(255,255,255);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(width,height));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Button元素
        JButton btnadd=new JButton("添加");
        btnadd.setFont(new Font("黑体",Font.PLAIN,20));
        btnadd.setBackground(color.CYAN);

        JButton btndelete=new JButton("删除");
        btndelete.setFont(new Font("黑体",Font.PLAIN,20));
        btndelete.setBackground(color.CYAN);

        JButton btnselect=new JButton("查询");
        btnselect.setFont(new Font("黑体",Font.PLAIN,20));
        btnselect.setBackground(color.CYAN);

        JButton btnupdate=new JButton("修改");
        btnupdate.setFont(new Font("黑体",Font.PLAIN,20));
        btnupdate.setBackground(color.CYAN);

        JButton btnsave=new JButton("保存信息");
        btnsave.setFont(new Font("黑体",Font.PLAIN,20));
        btnsave.setBackground(color.cyan);

        JButton btnsta=new JButton("统计信息");
        btnsta.setFont(new Font("黑体",Font.PLAIN,20));
        btnsta.setBackground(Color.cyan);

        btnadd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pets_clothes_add(menu);
            }
        });
        btndelete.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pets_clothes_delete(menu);
            }
        });
        btnselect.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pets_clothes_select(menu);
            }
        });
        btnupdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pets_clothes_update(menu);
            }
        });
        btnsave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pets_clothes_save.save_file();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnsta.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Pets_clothes_sta(menu);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //添加Button元素
        btnPanel.add(btnadd);
        btnPanel.add(btndelete);
        btnPanel.add(btnselect);
        btnPanel.add(btnupdate);
        btnPanel.add(btnsave);
        btnPanel.add(btnsta);
        this.add(btnPanel);

        //组装表格
        String [] ts={"编号","类型","尺寸","颜色","价格","销售状态"};
        titles=new Vector<>();
        for(String title:ts){
            titles.add(title);
        }
        tabledata=new Vector<>();

        tableModel=new DefaultTableModel(tabledata,titles);
        table=new JTable(tableModel){
            public boolean isCellEditable(int row,int colue){
                return false;
            }
        };

        //设置只能选中一行
        JScrollPane scrollPane=new JScrollPane(table);
        this.add(scrollPane);
        requerstData();
    }

    //请求数据
    public void requerstData() throws SQLException,ClassNotFoundException{
        tabledata.clear();
        Vector<Vector> data=getInformationInterface();
        for(Vector vector:data){
            tabledata.add(vector);
        }
        table.removeAll();
    }

    //获取信息
    public Vector<Vector> getInformationInterface() throws SQLException,ClassNotFoundException{
        String sql="select * from Pets_clothes";
        Vector<Vector> data=new Vector<>();
        PreparedStatement preparedStatement=ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();
        String id,style,size,color,price,Sales_status=null;
        while(rs.next()){
            Vector information=new Vector<>();
            id=rs.getString("id");
            style=rs.getString("style");
            size=rs.getString("size");
            color=rs.getString("color");
            price=rs.getString("price");
            Sales_status=rs.getString("Sales_status");
            information.add(id);
            information.add(style);
            information.add(size);
            information.add(color);
            information.add(price);
            information.add(Sales_status);
            data.add(information);
        }
        preparedStatement.close();
        rs.close();
        return data;
    }
}
