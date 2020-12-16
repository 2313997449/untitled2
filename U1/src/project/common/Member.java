package project.common;

import java.io.Serializable;

public class Member implements Serializable {
    private String memberNo;
    private double integral;
    public Member(){}
    public Member(String memberNo, double integral) {
        this.memberNo = memberNo;
        this.integral = integral;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo='" + memberNo + '\'' +
                ", integral=" + integral +
                '}';
    }
}
