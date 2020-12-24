package java71.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlCreate {
    public static void main(String[] args) {
        // ddl:
        //
        Connection con= java71.jdbc.DBUtil.getConnection();
        String sql="drop table mystudent";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(sql);
           //返回值一律是0
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            java71.jdbc.DBUtil.close(ps);
            java71.jdbc.DBUtil.close(con);
        }

    }
}
