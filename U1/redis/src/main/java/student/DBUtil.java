package student;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    public static String driver;
    public static  String url;
    public static String user;
    public static  String pass;
    static{
        try {
            Properties p = new Properties();
            p.load(DBUtil.class.getClassLoader().getResourceAsStream("zwb.properties"));


            driver=p.getProperty("driver");
            url=p.getProperty("url");
            user=p.getProperty("username");
            pass=p.getProperty("password");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //>System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
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
       // return null;
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
