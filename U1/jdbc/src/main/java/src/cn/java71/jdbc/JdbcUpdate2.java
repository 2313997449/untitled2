package src.cn.java71.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JdbcUpdate2 {
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
        String sql="update s_student set sname=?,enterdate=? where stuno=?";
        System.out.println(sql);
        PreparedStatement st=null;
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
             st=con.prepareStatement(sql);
             //占位符的位置从1开始
             st.setString(1,name);
             st.setDate(2,new java.sql.Date(df.parse(enterdate).getTime()));
             st.setLong(3,stuno);
             //>>>>st.setObject();
            int r=st.executeUpdate();
            System.out.printf("修改了%d条",r);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(null,st,con);
        }

    }
}
