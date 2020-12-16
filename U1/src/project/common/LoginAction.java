package project.common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Map;

//xml格式，保证验证通过xml中的信息来实现
public class LoginAction extends Action {

    public boolean check(String u,String p)
    {
        SAXReader reader=new SAXReader();
        try {
            Document doc = reader.read(LoginAction.class.getClassLoader().getResourceAsStream("project/common/users.xml"));
            Element e= (Element) doc.selectSingleNode("/users/admin[name='"+u+"'][pass='"+p+"']");

            return e!=null;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkB(String u,String p)
    {
        SAXReader reader=new SAXReader();
        try {
            Document doc = reader.read(LoginAction.class.getClassLoader().getResourceAsStream("project/common/users.xml"));
            Element el = (Element)doc.selectSingleNode("/users/control[name='"+u+"'][pass='"+p+"']");

            return el!=null;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    //
    @Override
    public Response execute(Request request) {

        String name=(String)request.get("username");
        String pass=(String)request.get("userpass");
        if(check(name,pass)){
            return new Response(true,"amin");
        }else if (checkB(name,pass)){
            return new Response(true,"control");
        }
        return  new Response(false,"登录失败，错误的用户名或者密码");
    }


}
