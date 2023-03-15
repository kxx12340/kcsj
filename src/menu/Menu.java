package menu;

import Log_in.Log_in;
import table.Pets_clothes_table;
import table.Pets_foods_table;
import table.Pets_table;
import table.Pets_toys_table;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class Menu {
    JFrame menu = new JFrame("宠物店管理系统");

    public Menu() throws SQLException, ClassNotFoundException, IOException {
        menu.setTitle("宠物店管理系统");
        menu.setSize(1000, 800);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLayout(null);
        init();
        menu.setVisible(true);
    }

    public void init() throws IOException, SQLException, ClassNotFoundException {
        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("设置");
        JMenuItem jMenuItem = new JMenuItem("退出登录");

        //退出登录菜单项的监听器
        jMenuItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Log_in();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    menu.dispose();
                }
            }
        });
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        menu.setJMenuBar(jMenuBar);

        //设置JSplitPane
        JSplitPane sp = new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(10);

        //设置左侧内容
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode spacer = new DefaultMutableTreeNode(""); // Add an empty node
        DefaultMutableTreeNode Pets = new DefaultMutableTreeNode("宠物信息管理");
        DefaultMutableTreeNode spacer2 = new DefaultMutableTreeNode(""); // Add an empty node
        DefaultMutableTreeNode Pets_foods = new DefaultMutableTreeNode("宠物食品信息管理");
        DefaultMutableTreeNode spacer3 = new DefaultMutableTreeNode(""); // Add an empty node
        DefaultMutableTreeNode Pets_clothes = new DefaultMutableTreeNode("宠物衣服信息管理");
        DefaultMutableTreeNode spacer4 = new DefaultMutableTreeNode(""); // Add an empty node
        DefaultMutableTreeNode Pets_toys = new DefaultMutableTreeNode("宠物玩具信息管理");

        root.add(spacer);
        root.add(Pets);
        root.add(spacer2);
        root.add(Pets_foods);
        root.add(spacer3);
        root.add(Pets_clothes);
        root.add(spacer4);
        root.add(Pets_toys);

        Color color = new Color(255, 255, 255);
        JTree tree = new JTree(root);

        tree.setBackground(color);
        //设置当前tree默认选中宠物信息管理
        tree.setSelectionRow(1);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object last=e.getNewLeadSelectionPath().getLastPathComponent();
                //添加需要的逻辑
                if(Pets.equals(last)){
                    try {
                        sp.setRightComponent(new Pets_table(menu));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    sp.setDividerLocation(150);
                } else if (Pets_foods.equals(last)) {
                    try {
                        sp.setRightComponent(new Pets_foods_table(menu));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    sp.setDividerLocation(150);
                }else if (Pets_clothes.equals(last)) {
                    try {
                        sp.setRightComponent(new Pets_clothes_table(menu));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    sp.setDividerLocation(150);
                }else if (Pets_toys.equals(last)) {
                    try {
                        sp.setRightComponent(new Pets_toys_table(menu));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    sp.setDividerLocation(150);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setPreferredSize(new Dimension(150, 0));
        leftPanel.add(scrollPane);
        sp.setLeftComponent(leftPanel);
        sp.setLeftComponent(tree);

        //设置右侧内容
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        sp.setRightComponent(new Pets_table(menu));

        //添加JSplitPane到窗口中
        menu.setContentPane(sp);

        //设置窗口可见
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}