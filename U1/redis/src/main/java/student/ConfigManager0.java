package student;

public class ConfigManager0 {
    //启动立即创建
    private static ConfigManager0 configManager;
   public static ConfigManager0 getInstance() throws InterruptedException {
       if (configManager==null){
           synchronized (ConfigManager0.class) {
               if (configManager==null) {
                   configManager = new ConfigManager0();
               }
           }
       }

       return configManager;
   }
   private ConfigManager0() throws InterruptedException {
       System.out.println("ConfigManager被创建");
       Thread.sleep(2300);
   }
}
