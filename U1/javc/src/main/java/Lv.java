import java.sql.*;

public class Lv {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java71";
        String username = "root";
        String password = "123456";

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("1------------               ");
            String sql;
            sql = "select * from s_subject";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("2--------------------------  ");

        String sql_u= "update  s_student set stuno = 3336 where sname='王武139';";
        stmt.executeUpdate(sql_u);
    }

}
