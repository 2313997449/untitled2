import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Da {
    //删除 PreparedSatement
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
