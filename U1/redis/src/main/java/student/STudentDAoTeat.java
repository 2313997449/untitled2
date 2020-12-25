package student;

import java.util.List;

public class STudentDAoTeat {
    public static void main(String[] args) {
        StudentDaoo daoo = new StudentDaoo();
        System.out.println("-------------");
        List list2 = daoo.search(1,10,"王","qq","1");
        list2.forEach(System.out::println);
    }
}
