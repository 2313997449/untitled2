import java.sql.*;

public class Le {
    public static void main(String[] args) throws ClassNotFoundException {
        //查询数据
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java71";
        String username = "root";
        String password = "123456";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("1------------               ");
            String sql;
            sql = "select * from s_subject";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("2--------------------------  ");
            while (rs.next()) {
                System.out.println("通过字段检索");
                int id = rs.getInt("id");
                String name = rs.getString("subjectname");
                int hour = rs.getInt("classhour");
                int gid = rs.getInt("gradeid");

                System.out.println("输出");
                System.out.println("编号" + id);
                System.out.println("课程" + name);
                System.out.println("课时" + hour);
                System.out.println("年级" + gid);
                System.out.println("\n");
            }
            rs.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }

    }


}
