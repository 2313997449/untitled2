import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lp {
    //添加数据
    public static void main(String[] arg){
        Connection conn;
        PreparedStatement stmt;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/java71?useSSL=false";
        String user = "root";
        String password = "123456";
        String sql = "insert into s_subject values (?,?,?,?)";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setInt(1, 66);
            stmt.setString(2, "曲率引擎");
            stmt.setInt(3, 26);
            stmt.setInt(4,3);
            stmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }


}
