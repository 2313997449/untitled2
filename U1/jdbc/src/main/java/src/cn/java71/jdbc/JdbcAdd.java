package src.cn.java71.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcAdd {
    public static void main(String[] args) {
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
        Scanner scanner=new Scanner(System.in);
        System.out.println("input grade name:");
        String gname=scanner.next();
        String sql="insert into s_grade(gname)values('"+gname+"')";
        System.out.println(sql);
        try {
            con = DriverManager.getConnection(url, "root", "root1234");

            statement = con.createStatement();
            int r=statement.executeUpdate(sql);
            System.out.println("增加了"+r+"条");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{

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
