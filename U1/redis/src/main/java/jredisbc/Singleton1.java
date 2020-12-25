package jredisbc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton1 {

   private Singleton1() {}

        private static Singleton1 single = new Singleton1();

        // 静态工厂方法
        public static Singleton1 getInstance() {
            return single;
    }
}
