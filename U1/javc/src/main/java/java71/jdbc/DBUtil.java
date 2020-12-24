package java71.jdbc;

import java.sql.*;

public class DBUtil {
    public static final String driver="com.mysql.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/java71";
    public static final String user="root";
    public static final String pass="123456";
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //>System.exit(0);
        }
    }
    private DBUtil(){}
    public static Connection getConnection(){
        try {
            Connection con= DriverManager.getConnection(url,user,pass);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接错误！",e);
        }
        //return null;
    }
    public static void close(ResultSet rs,Statement st,Connection con){
        close(rs);
        close(st);
        close(con);
    }
    public static void close(ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
