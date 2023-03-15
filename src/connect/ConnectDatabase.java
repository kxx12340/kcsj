package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection connection(){
        Connection con=null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Course_design";
        String user = "root";
        String password = "123456";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库链接失败！");
        }

        return con;
    }
}
