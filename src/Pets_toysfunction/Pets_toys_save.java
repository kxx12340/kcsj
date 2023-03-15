package Pets_toysfunction;

import connect.ConnectDatabase;
import entity.Pets;
import entity.Pets_clothes;
import entity.Pets_toys;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_toys_save {
    public static void save_file() throws SQLException, IOException {
        String sql="select * from Pets_toys";
        PreparedStatement ps=ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);

        List<Pets_toys> list= new ArrayList<>();

        while(rs.next()){
            int id= (int) rs.getObject("id");
            String type= (String) rs.getObject("type");
            String color= (String) rs.getObject("color");
            int price= (int) rs.getObject("price");
            int Sales_status= (int) rs.getObject("Sales_status");

            Pets_toys pets_toys=new Pets_toys(id,type,color,price,Sales_status);

            list.add(pets_toys);
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\导出信息\\宠物玩具信息.txt"));
        for(Pets_toys pets_toys:list){
            bw.write(pets_toys.getId()+"    "+ pets_toys.getType()+"    "+pets_toys.getColor()+"    "+pets_toys.getPrice()+"    "+pets_toys.getSales_status()+"\n");
        }
        bw.close();
        ps.close();
        rs.close();
        JOptionPane.showMessageDialog(null,"保存成功！");
    }
}
