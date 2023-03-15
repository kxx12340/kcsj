package petsfunction;

import connect.ConnectDatabase;
import entity.Pets;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_save {
    public static void save_file() throws SQLException, IOException {
        String sql="select * from Pets";
        PreparedStatement ps=ConnectDatabase.connection().prepareStatement(sql);
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
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\导出信息\\宠物信息.txt"));
        for(Pets pets:list){
            bw.write(pets.getId()+"    "+ pets.getName()+"    "+pets.getAge()+"    "+pets.getColor()+"    "+pets.getRace()+"    "+pets.getPrice()+"    "+pets.getSales_status()+"\n");
        }
        bw.close();
        ps.close();
        rs.close();
        JOptionPane.showMessageDialog(null,"保存成功！");
    }
}
