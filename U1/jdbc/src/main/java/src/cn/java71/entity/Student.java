package src.cn.java71.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private long stuno;
    private String sname;
    private String sex;
    private String telephone;
    private String qq;
    private String wechat;
    private long gradeid;
    private Date enterdate;
    private String fromcity;
    private Date birthday;
    private String address;
    private String pass;
    private String idcardpic;
    private String email;

    public Student() {}

    public Student(String sname, String sex, long gradeid, Date enterdate, Date birthday) {
        this.sname = sname;
        this.sex = sex;
        this.gradeid = gradeid;
        this.enterdate = enterdate;

        this.birthday = birthday;
    }

    public Student(String sname, String sex, String telephone, String qq,
                   String wechat, long gradeid, Date enterdate, String fromcity,
                   Date birthday, String address, String pass, String idcardpic, String email) {
        this.sname = sname;
        this.sex = sex;
        this.telephone = telephone;
        this.qq = qq;
        this.wechat = wechat;
        this.gradeid = gradeid;
        this.enterdate = enterdate;
        this.fromcity = fromcity;
        this.birthday = birthday;
        this.address = address;
        this.pass = pass;
        this.idcardpic = idcardpic;
        this.email = email;
    }

    public Student(long stuno, String sname, String sex, String telephone, String qq,
                   String wechat, long gradeid, Date enterdate, String fromcity,
                   Date birthday, String address, String pass, String idcardpic, String email) {
        this.stuno = stuno;
        this.sname = sname;
        this.sex = sex;
        this.telephone = telephone;
        this.qq = qq;
        this.wechat = wechat;
        this.gradeid = gradeid;
        this.enterdate = enterdate;
        this.fromcity = fromcity;
        this.birthday = birthday;
        this.address = address;
        this.pass = pass;
        this.idcardpic = idcardpic;
        this.email = email;
    }

    public long getStuno() {
        return stuno;
    }

    public void setStuno(long stuno) {
        this.stuno = stuno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public long getGradeid() {
        return gradeid;
    }

    public void setGradeid(long gradeid) {
        this.gradeid = gradeid;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIdcardpic() {
        return idcardpic;
    }

    public void setIdcardpic(String idcardpic) {
        this.idcardpic = idcardpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno=" + stuno +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", gradeid=" + gradeid +
                ", enterdate=" + enterdate +
                ", fromcity='" + fromcity + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", pass='" + pass + '\'' +
                ", idcardpic='" + idcardpic + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
