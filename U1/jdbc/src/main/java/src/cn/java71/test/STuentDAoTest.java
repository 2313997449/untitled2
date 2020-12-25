package src.cn.java71.test;


import src.cn.java71.dao.StudentDao;

import java.util.List;

public class STuentDAoTest {
    public static void main(String[] args) {
        StudentDao dao=new StudentDao();
//        List list = dao.search(1, 10, "王", "1", "1");
//        list.forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        List list2 = dao.search(1, 10, "", "1", "1","2");
        list2.forEach(System.out::println);
    }
}
