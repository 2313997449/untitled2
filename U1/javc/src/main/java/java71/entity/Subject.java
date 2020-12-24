package cn.java71.entity;

import java.io.Serializable;

//对应s_subject表
public class Subject implements Serializable {
    private long id;
    private String subjectname;
    private int classhour;
    private long gradeid;
    public Subject(){

    }
    public Subject(  String subjectname, int classhour, long gradeid) {
        this.subjectname = subjectname;
        this.classhour = classhour;
        this.gradeid = gradeid;
    }
    public Subject(long id, String subjectname, int classhour, long gradeid) {
        this.id = id;
        this.subjectname = subjectname;
        this.classhour = classhour;
        this.gradeid = gradeid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getClasshour() {
        return classhour;
    }

    public void setClasshour(int classhour) {
        this.classhour = classhour;
    }

    public long getGradeid() {
        return gradeid;
    }

    public void setGradeid(long gradeid) {
        this.gradeid = gradeid;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectname='" + subjectname + '\'' +
                ", classhour=" + classhour +
                ", gradeid=" + gradeid +
                '}';
    }
}
