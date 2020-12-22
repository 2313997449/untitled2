import java.sql.*;

public class Lq {
    public static void main(String[] args) throws ClassNotFoundException {
        //计算
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java71";
        String username = "root";
        String password = "123456";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("1------------               ");
            String sql;
            sql = "select stuno from s_student";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("2--------------------------  ");
            int count =0;
            while (rs.next()){

              //  System.out.println("通过字段检索");
               count=count+1;
               // int id = rs.getInt("stuno");
               // System.out.println(id);


            }
            System.out.println("学生数为"+count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
    }