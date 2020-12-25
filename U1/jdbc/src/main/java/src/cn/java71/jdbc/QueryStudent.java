package src.cn.java71.jdbc;

import java.sql.*;

public class QueryStudent {
    public static void main(String[] args) {
        //不起作用
        String sql="select * from s_student order by ? asc";
        Connection con=DBUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,"enterdate");
             rs=ps.executeQuery();
             while(rs.next()){
                 long no=rs.getLong("stuno");
                 String name=rs.getString("sname");
                 String sex=rs.getString("sex");
                 Date enterdate=rs.getDate("enterdate");
                 System.out.println(no+","+name+","+sex+","+enterdate);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,con);
        }

    }
}
