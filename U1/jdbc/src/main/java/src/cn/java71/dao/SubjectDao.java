package src.cn.java71.dao;


import src.cn.java71.entity.Subject;
import src.cn.java71.jdbc.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//data acess object
//对应表s_subject
public class SubjectDao {
    //不管输入，不管输出
    //同时也要显示年级名称。。。
    public List<Subject> findALL() {
        //String sql = "select id,subjectname,classhour,gradeid from s_subject";
        String sql = "select s.id,subjectname,classhour,gradeid,gname from " +
                "s_subject s inner join s_grade g on(s.gradeid=g.id)";
        List<Subject> datas = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getLong("id"));
                s.setSubjectname(rs.getString("subjectname"));
                s.setClasshour(rs.getInt("classhour"));
                s.setGradeid(rs.getLong("gradeid"));
                //???
                s.setGname(rs.getString("gname"));
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
    //>>>

    /**
     * 分页
     * @param pageNo  页号
     * @param pageSize 页大小
     * @return
     */
    public List<Subject> search(int pageNo,int pageSize){
        String sql = "select id,subjectname,classhour,gradeid from s_subject limit ?,?";
        int start=(pageNo-1)*pageSize;
        start=start<0?0:start;

        List<Subject> datas = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getLong("id"));
                s.setSubjectname(rs.getString("subjectname"));
                s.setClasshour(rs.getInt("classhour"));
                s.setGradeid(rs.getLong("gradeid"));
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

    public Subject get(long id) {
            String sql = "select id,subjectname,classhour,gradeid from s_subject where id=?";
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = con.prepareStatement(sql);
                ps.setLong(1,id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Subject s = new Subject();
                    s.setId(rs.getLong("id"));
                    s.setSubjectname(rs.getString("subjectname"));
                    s.setClasshour(rs.getInt("classhour"));
                    s.setGradeid(rs.getLong("gradeid"));
                    return s;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("查询课程信息失败！", e);
            } finally {
                DBUtil.close(rs, ps, con);
            }
            return null;
    }

    public int add(Subject subject) {
        String sql = "insert into s_subject(subjectname,classhour,gradeid) values(?,?,?)";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        int i=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,subject.getSubjectname());
            ps.setInt(2,subject.getClasshour());
            ps.setLong(3,subject.getGradeid());
            i = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加课程信息失败！", e);
        } finally {
            DBUtil.close(null, ps, con);
        }
        return i;
    }

    public int update(Subject s) {
        return 0;
    }

    public int del(long id) {
        return 0;
    }
}
