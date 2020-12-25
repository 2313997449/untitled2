package src.cn.java71.test;

import java.util.Properties;

public class ProTest {
    public static void main(String[] args) throws  Exception {
        //System.out.println(new File("").getAbsolutePath());
        Properties p=new Properties();
        //p.load(new FileInputStream("jdbc/src/jdbc.properties"));
        p.load(ProTest.class.getClassLoader().getResourceAsStream("jdbc.properties"));

        System.out.println(p);
    }
}
