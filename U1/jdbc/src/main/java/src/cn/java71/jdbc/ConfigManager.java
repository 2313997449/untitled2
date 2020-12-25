package src.cn.java71.jdbc;

public class ConfigManager {
    //启动立即创建,饿汉模式
    private static ConfigManager config=new ConfigManager();

    public static ConfigManager getInstance(){
        return config;
    }
    private ConfigManager(){
        //>>> byte b[]=new byte[1000000000];
    }
}
