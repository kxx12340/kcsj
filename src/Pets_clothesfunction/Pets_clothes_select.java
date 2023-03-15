package Pets_clothesfunction;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Pets_clothes_select {
    JFrame pets_clothes_select =new JFrame("宠物信息管理");
    public Pets_clothes_select(JFrame menu){
        pets_clothes_select.setTitle("宠物信息管理");
        pets_clothes_select.setSize(400,300);
        pets_clothes_select.setLocationRelativeTo(null);
        pets_clothes_select.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pets_clothes_select.setResizable(false);
        pets_clothes_select.setLayout(null);
        init(menu);
        pets_clothes_select.setVisible(true);
    }
    public void init(JFrame menu){
        JLabel label1=new JLabel("请输入需要查询的编号(id):");
        label1.setFont(new Font("黑体", Font.PLAIN,20));
        label1.setBounds(30,30,300,30);
        pets_clothes_select.add(label1);

        JTextField textField1=new JTextField();
        textField1.setFont(new Font("黑体", Font.PLAIN,20));
        textField1.setBounds(30,100,300,30);
        pets_clothes_select.add(textField1);

        JButton btnselect=new JButton("查询");
        btnselect.setFont(new Font("黑体",Font.PLAIN,20));
        btnselect.setBackground(Color.CYAN);
        btnselect.setBounds(30,200,100,50);
        pets_clothes_select.add(btnselect);

        JButton btnback=new JButton("返回");
        btnback.setFont(new Font("黑体",Font.PLAIN,20));
        btnback.setBackground(Color.CYAN);
        btnback.setBounds(230,200,100,50);
        pets_clothes_select.add(btnback);

        btnselect.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid=textField1.getText();
                try {
                    new Result(pid,menu);
                    pets_clothes_select.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnback.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pets_clothes_select.dispose();
            }
        });
    }
}
