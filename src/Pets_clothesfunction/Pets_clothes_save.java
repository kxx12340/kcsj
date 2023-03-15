package Pets_clothesfunction;

import connect.ConnectDatabase;
import entity.Pets;
import entity.Pets_clothes;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_clothes_save {
    public static void save_file() throws SQLException, IOException {
        String sql="select * from Pets_clothes";
        PreparedStatement ps=ConnectDatabase.connection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);

        List<Pets_clothes> list= new ArrayList<>();

        while(rs.next()){
            int id= (int) rs.getObject("id");
            String style= (String) rs.getObject("style");
            String size= (String) rs.getObject("size");
            String color= (String) rs.getObject("color");
            int price= (int) rs.getObject("price");
            int Sales_status= (int) rs.getObject("Sales_status");

            Pets_clothes pets_clothes=new Pets_clothes(id,style,size,color,price,Sales_status);

            list.add(pets_clothes);
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\导出信息\\宠物衣服信息.txt"));
        for(Pets_clothes pets_clothes:list){
            bw.write(pets_clothes.getId()+"    "+ pets_clothes.getStyle()+"    "+pets_clothes.getSize()+"    "+pets_clothes.getColor()+"    "+pets_clothes.getPrice()+"    "+pets_clothes.getSales_status()+"\n");
        }
        bw.close();
        ps.close();
        rs.close();
        JOptionPane.showMessageDialog(null,"保存成功！");
    }
}
