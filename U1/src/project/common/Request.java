package project.common;

import java.io.Serializable;
import java.util.HashMap;

//传输载体
//...................
//请求
public class Request extends HashMap<String,Object> implements Serializable {
    public static final long serialVersionUID = 71L;
    //本次干的活
    //本次请求要完成的功能
    private String action;

    public Request(){

    }
    public Request(String a){
        this.action=a;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    @Override
    public String toString() {
        return "Request{" +
                "action='" + action + '\'' +
               " ,内部数据："+ super.toString()+
                '}';
    }
}
