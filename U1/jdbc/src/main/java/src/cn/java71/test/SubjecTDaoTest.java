package src.cn.java71.test;


import src.cn.java71.dao.SubjectDao;
import src.cn.java71.entity.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjecTDaoTest {
    public static void main(String[] args) {
        SubjectDao dao=new SubjectDao();
        List<Subject> list = dao.findALL();
        list.forEach(System.out::println);
        Scanner sc=new Scanner(System.in);
        Subject subject=new Subject();
        System.out.println("请输入课程名：");
        subject.setSubjectname(sc.next());
        System.out.println("课时：");
        subject.setClasshour(sc.nextInt());
        System.out.println("所属年级：");
        subject.setGradeid(sc.nextLong());

        int r=dao.add(subject);
        System.out.println(r>0?"新增成功":"新增失败");
    }
}
