package controlMessage;

import java.io.*;
import java.util.Scanner;

public class StudentUi {
    public static void main(String[] args) {

    }
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("学员的编号：");
        int id = scanner.nextInt();
        System.out.print("更新学员的姓名：");
        String name = scanner.nextLine();
        System.out.print("更新学员的年龄：");
        int age = scanner.nextInt();
        StudentRightCeng student = new StudentRightCeng();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        //  StudentDao studentDao = new StudentDao();
        //  studentDao.update(student);
    }
    public static void Rmove(){

 /*键盘输入学员信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("查询学员的编号：");
        String id = scanner.nextLine();
        StudentDao studentDao = new StudentDao();
        studentDao.read(id);
        Scanner scanner = new Scanner(System.in);
        System.out.print("删除学员的编号：");
        String id = scanner.nextLine();
        StudentDao studentDao = new StudentDao();
        studentDao.delete(id);
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名：" );
        String name = scanner.nextLine();
        System.out.print("年龄：" );
        String age = scanner.nextLine();
        //封装成JavaBean对象
        Student student = new Student();
        student.setId(IdUtil.getId());
        student.setName(name);
        student.setAge(age);
        //调用Dao对象
        StudentDao studentDao = new StudentDao();
        boolean flag = studentDao.create(student);
        if(flag){
            System.out.println("操作成功");
        }else{
            System.out.println("操作失败");
        }
        */
    }
    public  class ADD{
        public int getID() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("file://D:/U1/src/DateStidengCeng.xml"));
            int id = br.read();
            int temp = Integer.parseInt(String.valueOf(id))+1;  //(int 型)
            BufferedWriter bw = new BufferedWriter(new FileWriter("//D:/U1/src/DateStidengCeng.xml"));
            bw.write(temp+"");
            bw.flush();
            bw.close();
            return id;
        }
    }










    }

