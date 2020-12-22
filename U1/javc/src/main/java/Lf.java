import java.sql.*;

public class Lf {
    public static void main(String[] args) throws ClassNotFoundException {
        //修改数据
        Class.forName("com.mysql.jdbc.Driver");
        String UName = "root";
        String Upass = "123456";
        Connection conn ;
        String url = "jdbc:mysql://localhost:3306/java71";
        try {
            conn= DriverManager.getConnection(url,UName,Upass);

            PreparedStatement psql = conn.prepareStatement("update s_student set stuno = ? where sname = ?");
            psql.setInt(1,3663);
            psql.setString(2,"李双");
            psql.executeUpdate();

            System.out.println("完毕");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
