package src.cn.java71.jdbc;


import java.sql.*;
import java.util.Properties;

public class DBUtil {
    //    public static final String driver="com.mysql.jdbc.Driver";
//    public static final String url="jdbc:mysql://localhost:3306/java71?useSSL=false";
//    public static final String user="root";
//    public static final String pass="root1234";
    private static  String driver;
    private static  String url;
    private static  String user;
    private static  String pass;

    static {
        Properties p = new Properties();
        try {
            p.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            driver=p.getProperty("driver");
            url=p.getProperty("url");
            user=p.getProperty("user");
            pass=p.getProperty("pass");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
            //>System.exit(0);
        }
    }

    private DBUtil() {
    }

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接错误！", e);
        }
        //return null;
    }

    public static void close(ResultSet rs, Statement st, Connection con) {
        close(rs);
        close(st);
        close(con);
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
