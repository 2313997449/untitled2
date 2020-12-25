package src.cn.java71.jdbc;

public class ConfigManager0 {
    //启动立即创建
    private static ConfigManager0 config;

    //懒汉模式：会有线程安全问题，多线程的情况下，会创建多个实例
//    public static ConfigManager0 getInstance(){
//        if(config==null)
//        {
//            config=new ConfigManager0();
//        }
//        return config;
//    }
    //改进的懒汉模式
//    public static synchronized ConfigManager0 getInstance(){
//        if(config==null)
//        {
//            config=new ConfigManager0();
//        }
//        return config;
//    }
    //进一步改进
    public static ConfigManager0 getInstance() {
        if (config == null) {
            synchronized (ConfigManager0.class) {
                if (config == null) {
                    config = new ConfigManager0();
                }
            }
        }
        return config;
    }

    private ConfigManager0() {
        //>>> byte b[]=new byte[1000000000];
        System.out.println("config  mananger 被创建了。。。");
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
