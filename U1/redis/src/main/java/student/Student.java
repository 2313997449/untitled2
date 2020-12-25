package student;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {
private long stuno;
private  String sname;
private String sex;
private  long telephone;
private Date enterdate;
private  String fromcity;

    public Student() {
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

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
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

    public Student(long stuno, String sname, String sex, long telephone, Date enterdate, String fromcity) {
        this.stuno = stuno;
        this.sname = sname;
        this.sex = sex;
        this.telephone = telephone;
        this.enterdate = enterdate;
        this.fromcity = fromcity;
    }

    public Student(long stuno, String sname, String sex, long telephone, String fromcity) {
        this.stuno = stuno;
        this.sname = sname;
        this.sex = sex;
        this.telephone = telephone;
        this.fromcity = fromcity;
    }
    @Override
    public String toString() {
        return "Student{" +
                "stuno=" + stuno +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone=" + telephone +
                ", enterdate=" + enterdate +
                ", fromcity='" + fromcity + '\'' +
                '}';
    }
}
