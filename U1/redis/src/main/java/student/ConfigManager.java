package student;

public class ConfigManager {
    //启动立即创建
    private static  ConfigManager configManager = new ConfigManager();
   public static ConfigManager getInstance(){
       return configManager;
   }
   private ConfigManager(){

   }
}
