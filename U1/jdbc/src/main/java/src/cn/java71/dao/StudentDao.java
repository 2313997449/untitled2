package src.cn.java71.dao;


import src.cn.java71.entity.Student;
import src.cn.java71.jdbc.DBUtil;
import src.cn.java71.jdbc.StrUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    //???

    /**
     * 如果三个条件有一个为空，则不加这个条件
     *
     * @param pageNo
     * @param pageSize
     * @param sname
     * @param qq
     * @param wechat
     * @return
     */
    public List<Student> search(int pageNo, int pageSize, String sname, String qq, String wechat,String telephone) {
        String sql = "select * from s_student where 1=1 ";
        List<Object> params=new ArrayList<>();//专门放参数
        if (!StrUtil.isBlank(sname))
        {
            sql += " and sname like \"%\"?\"%\"";
            params.add(sname);
        }
        // like "%"?"%"
        if (!StrUtil.isBlank(qq))
        {
            sql += " and qq like \"%\"?\"%\"";
            params.add(qq);
        }
        if (!StrUtil.isBlank(wechat))
        {
            sql += " and  wechat like \"%\"?\"%\"";
            params.add(wechat);
        }
        if (!StrUtil.isBlank(telephone))
        {
            sql += " and  wechat like \"%\"?\"%\"";
            params.add(telephone);
        }
        int start = (pageNo - 1) * pageSize;
        start = start < 0 ? 0 : start;
        sql += " limit " + start + "," + pageSize;
        System.out.println("sql="+sql);
        System.out.println("参数:"+params);
        List<Student> datas = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            int from=1;
            for(int i=0;i<params.size();i++){
                ps.setObject(i+1,params.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStuno(rs.getLong("stuno"));
                s.setSname(rs.getString("sname"));
                s.setSex(rs.getString("sex"));
                s.setTelephone(rs.getString("telephone"));
                s.setQq(rs.getString("qq"));
                s.setWechat(rs.getString("wechat"));
                s.setGradeid(rs.getInt("gradeid"));
                s.setEnterdate(rs.getDate("enterdate"));
                s.setFromcity(rs.getString("fromcity"));
                s.setBirthday(rs.getDate("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPass(rs.getString("pass"));
                s.setIdcardpic(rs.getString("idcardpic"));
                s.setEmail(rs.getString("email"));
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
