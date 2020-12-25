package src.cn.java71.jdbc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTon {
    public static void main(String[] args) {
//        ConfigManager m1=ConfigManager.getInstance();
//        ConfigManager m2=ConfigManager.getInstance();
//        System.out.println(m1==m2);
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++)
            es.execute(() -> {
                System.out.println(ConfigManager0.getInstance());
            });
        es.shutdown();
    }
}
