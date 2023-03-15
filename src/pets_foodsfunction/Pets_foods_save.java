package pets_foodsfunction;

import connect.ConnectDatabase;
import entity.Pets;
import entity.Pets_foods;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pets_foods_save {
    public static void save_file() throws SQLException, IOException {
        String sql="select * from Pets_foods";
        PreparedStatement ps=ConnectDatabase.connection().prepareStatement(sql);
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
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\导出信息\\宠物食品信息.txt"));
        for(Pets_foods pets_foods:list){
            bw.write(pets_foods.getId()+"    "+ pets_foods.getName()+"    "+pets_foods.getFlavor()+"    "+pets_foods.getType()+"   "+pets_foods.getPrice()+"    "+pets_foods.getSales_status()+"\n");
        }
        bw.close();
        ps.close();
        rs.close();
        JOptionPane.showMessageDialog(null,"保存成功！");
    }
}
