package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        //新增
        StudentDao student=new StudentDao();
        Scanner sc=new Scanner(System.in);
        Student student1=new Student();
        System.out.println("输入学生学号：");
        student1.setStuno(sc.nextLong());
        System.out.println("输入学生姓名：");
        student1.setSname(sc.next());
        System.out.println("输入学生性别：");
        student1.setSex(sc.next());
        System.out.println("学生手机号码：");
        student1.setTelephone(sc.nextLong());
        System.out.println("来自哪个城市：");
        student1.setFromcity(sc.next());
        int r=student.add(student1);
        System.out.println(r>0?"新增成功":"新增失败");

        //修改
        System.out.println("要修改的学生学号：");
        int a= sc.nextInt();
        System.out.println("修改后的联系电话：");
        Long telephone=sc.nextLong();
        int t=student.update(telephone,a);
        System.out.println(t>0?"修改成功":"修改失败！");

//查询
        System.out.println("输入查询开始的页号：");
        int l=sc.nextInt();
        System.out.println("输入页大小：");
        int b=sc.nextInt();
        List<Student> list= student.search(l,b);
        for (Student m:list
             ) {
            System.out.println(m.toString());
        }
    }
}
