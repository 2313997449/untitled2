package student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentDaooTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentDaoo studentDaoo = new StudentDaoo();
        System.out.println("请输入查询页数");
        int pageNo = in.nextInt();
        System.out.println("请输入查询数量");
        int  pageSize = in.nextInt();
        System.out.println("请输入姓名");
        String sname = in.next();
        System.out.println("请输入qq");
       String qq = in.next();
        System.out.println("请输入微信");
        String wechat = in.next();
        List<Student> dates = new ArrayList<>();
        dates= studentDaoo.search(pageNo,pageSize,sname,qq,wechat);
        Iterator<Student> it = dates.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }



    }
}
