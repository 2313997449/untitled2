import java.sql.*;

public class Ld {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java71";
        String username = "root";
        String password = "123456";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("1------------               ");
            String sql;
         //   sql = "select * from s_subject";
           // ResultSet rs = stmt.executeQuery(sql);
            System.out.println("2--------------------------  ");
            String sql2 = "INSERT into s_subject (id,subjectname,classhour,gradeid) values('93','反物质推进','99','3');";
//            psql.setInt(1,67);
//            psql.setString(2,"曲率引擎");
//            psql.setInt(3,16);
//            psql.setInt(4,6);
            stmt.executeUpdate(sql2);
            System.out.println("3----------------------------");
            //rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





    }
}
