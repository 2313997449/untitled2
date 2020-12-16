package project.common;

import java.io.Serializable;
import java.util.HashMap;
//回复，响应
public class Response extends HashMap<String,Object> implements Serializable {
    public static final long serialVersionUID = 71L;
    //是否成功
    private boolean success;//
    //返回的信息
    private String msg;
    public Response(){

    }
    public Response(boolean b){
        this.success = b;
    }
    public Response(boolean b,String msg){
        this.success=b;
        this.msg=msg;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", msg='" + msg + '\'' +","+super.toString()+
                '}';
    }
}

