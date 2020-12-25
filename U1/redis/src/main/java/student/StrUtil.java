package student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StrUtil {
    private StrUtil(){}
    private static SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
    public static boolean isBlank(Object s){
        if (s==null){
            return true;
       }else if (s instanceof  String){
            return s.equals("");

        }
        return  false;
    }
    public static Date toDate(String str){
        try{
            return DF.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
