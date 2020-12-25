package src.cn.java71.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcUpdate {
    public static void main(String[] args) {
        Connection con=DBUtil.getConnection();
        //根据学号，修改学生，修改名字，和入学日期
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号：");
        long stuno=sc.nextLong();
        System.out.println("新名字：");//输入 李斯' --
        sc.nextLine();
        String name=sc.nextLine();
        //>>>name=name.replaceAll("'","\\,");

        System.out.println("入学日期：");
        String enterdate=sc.next();
        String sql="update mystudent set sname='"+name+"',enterdate='"+enterdate+"' where stuno="+stuno;
        System.out.println(sql);
        Statement st=null;
        try {
             st=con.createStatement();
            int r=st.executeUpdate(sql);
            System.out.printf("修改了%d条",r);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(null,st,con);
        }

    }
}
