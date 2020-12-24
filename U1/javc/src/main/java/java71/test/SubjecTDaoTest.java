package java71.test;

import java71.dao.SubjectDao;
import sgrade.Grade;


import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class SubjecTDaoTest {
    public static void main(String[] args) {
        search();
    }


    public static void add() {
        SubjectDao dao=new SubjectDao();
        List<cn.java71.entity.Subject> list = dao.findALL();
        list.forEach(System.out::println);
        Scanner sc=new Scanner(System.in);
        cn.java71.entity.Subject subject=new cn.java71.entity.Subject();
        System.out.println("请输入课程名：");
        subject.setSubjectname(sc.next());
        System.out.println("课时：");
        subject.setClasshour(sc.nextInt());
        System.out.println("所属年级：");
        subject.setGradeid(sc.nextLong());

        int r=dao.add(subject);
        System.out.println(r>0?"新增成功":"新增失败");
    }
    public static void search(){
        SubjectDao sdao = new SubjectDao();
        System.out.println("请入页号");
        Scanner sc=new Scanner(System.in);
        int pageNo= sc.nextInt();
        System.out.println("请入每页查询数量");
        int pageSize = sc.nextInt();

        List<cn.java71.entity.Subject> list = sdao.search(pageNo,pageSize);
        ListIterator<cn.java71.entity.Subject> it = list.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void alter(){

        Scanner sc=new Scanner(System.in);
        cn.java71.entity.Subject subject=new cn.java71.entity.Subject();

        System.out.println("请输入需要修改课程的:id");
        int id = sc.nextInt();
         System.out.println("请输入修改后的课程名");
         String subjectname = sc.next();
        System.out.println("请输入修改后的课时");
        int classhour = sc.nextInt();
        System.out.println("请输入修改后的所属年级");
        int gradedid =sc.nextInt();
        SubjectDao dao = new SubjectDao();
        int r=dao.get(id,subjectname,classhour,gradedid);
        System.out.println(r>0?"修改成功":"修改失败");
    }





}
