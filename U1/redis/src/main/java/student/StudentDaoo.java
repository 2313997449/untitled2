package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoo {
    public List search(int pageNo, int pageSize, String sname, String qq, String wechat) {
        String sql = "select * from s_student where 1=1" ;
        List<Object> params = new ArrayList<>();
        if (!StrUtil.isBlank(sname));
            sql += "and sname like \"%\"?\"%\"";
        params.add(sname);
        if (!StrUtil.isBlank(qq))
            sql += "and qq like \"%\"?\"%\"";
        params.add(qq);
        if (!StrUtil.isBlank(wechat))
            sql += "and wechat like \"%\"?\"%\"";
        params.add(wechat);
        int start = (pageNo - 1) * pageSize;
        start = start < 0 ? 0 : start;
        sql += "limit" + start + "," + pageSize;
        System.out.println("sql  "+sql);
        System.out.println("----------0-------");
        List<Student> datas = new ArrayList<>();
        System.out.println("--------1--------");
        Connection con = DBUtil.getConnection();
        System.out.println("--------2--------");
        PreparedStatement ps = null;
        System.out.println("-----3-----");
        ResultSet rs = null;
        System.out.println("-----4-----");
        try {
            ps = con.prepareStatement(sql);
            int from = 1;
            for (int i=0;i<params.size();i++){
                ps.setObject(i+1,params.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStuno(rs.getLong("stuno"));
                s.setSname(rs.getString("sname"));
                s.setSex(rs.getString("sex"));
                s.setTelephone(rs.getLong("telephone"));
                s.setEnterdate(rs.getDate("enterdate"));
                s.setFromcity(rs.getString("fromcity"));
                datas.add(s);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

           return datas;
    }
}
