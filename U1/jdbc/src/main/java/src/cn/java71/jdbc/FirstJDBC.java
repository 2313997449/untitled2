package src.cn.java71.jdbc;

import java.io.IOException;
import java.sql.*;

public class FirstJDBC {
    //select
    //其他是一组
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/java71?useSSL=false";
        Connection con = DriverManager.getConnection(url, "root", "root1234");
        System.out.println(con.getClass().getName());
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from s_student");
        while(rs.next()){
            long no=rs.getLong("stuno");
            String name=rs.getString("sname");
            String sex=rs.getString("sex");
            Date enterdate=rs.getDate("enterdate");
            System.out.println(no+","+name+","+sex+","+enterdate);
        }
        rs.close();
        statement.close();
        con.close();
    }
}
