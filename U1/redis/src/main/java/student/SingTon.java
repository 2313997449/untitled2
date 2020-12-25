package student;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingTon {
    //最简单的单列
    public static void main(String[] args) {
        /*
        ConfigManager m1 = ConfigManager.getInstance();
        ConfigManager m2 = ConfigManager.getInstance();
        System.out.println(m1==m2);

         */
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=1;i<=10;i++)
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(ConfigManager0.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        es.shutdown();

    }
    //缺点：浪费内存
}
