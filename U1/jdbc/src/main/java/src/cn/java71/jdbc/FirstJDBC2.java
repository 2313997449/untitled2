package src.cn.java71.jdbc;

import java.sql.*;

public class FirstJDBC2 {
    //select
    //其他是一组
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        //连接字符串
        String url="jdbc:mysql://localhost:3306/java71?useSSL=false";
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, "root", "root1234");
            System.out.println(con.getClass().getName());
            statement = con.createStatement();
            rs = statement.executeQuery("select * from s_student");
            while(rs.next()){
                long no=rs.getLong("stuno");
                String name=rs.getString("sname");
                String sex=rs.getString("sex");
                Date enterdate=rs.getDate("enterdate");
                System.out.println(no+","+name+","+sex+","+enterdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
