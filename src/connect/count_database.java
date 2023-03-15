package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class count_database {
    public static int addAccount(String username,String password) throws SQLException,ClassNotFoundException {
        String sql="insert into user(username,password) value(?,?)";
        PreparedStatement st= ConnectDatabase.connection().prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        int count=st.executeUpdate();
        return count;
    }
    public static int checkAccount(String username,String password)throws SQLException,ClassNotFoundException{
        String sql="select * from user where username=? and password=?";
        PreparedStatement st=ConnectDatabase.connection().prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        if(rs.next())
            return 1;
        else
            return 0;
    }
}
