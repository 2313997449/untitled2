package student;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    //增加
    public int add(Student student) {
        String sql = "insert into s_student(stuno,sname,sex,telephone,fromcity) values(?,?,?,?,?)";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, student.getStuno());
            ps.setString(2, student.getSname());
            ps.setString(3, student.getSex());
            ps.setLong(4, student.getTelephone());
//            ps.setDate(5,student.getEnterdate());
            ps.setString(5, student.getFromcity());
            i = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加学生信息失败！", e);
        } finally {
            DBUtil.close(null, ps, con);
        }
        return i;
    }

    //修改
    public int update(Long telephone, int id) {
        int m = 0;
        Connection con = DBUtil.getConnection();
        PreparedStatement st = null;

        String sql = "update s_student set telephone=? where stuno=?";
        try {
            st = con.prepareStatement(sql);
            st.setLong(1, telephone);
            st.setInt(2, id);
            m = st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(null, st, con);
        }
        return m;

    }

    //分页查询
    public List<Student> search(int pageNo, int pageSize) {
        String sql = "select stuno,sname,sex,telephone,enterdate,fromcity from s_student limit ?,?";
        int start = (pageNo - 1) * pageSize;
        start = start < 0 ? 0 : start;

        List<Student> datas = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, pageSize);
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
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询课程信息失败！", e);
        } finally {
            DBUtil.close(rs, ps, con);
        }
        return datas;
    }
}
