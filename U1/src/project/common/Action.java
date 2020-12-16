package project.common;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

//所有的动作
public abstract class Action {
    public static final String FILE_NAME = "products.xml";
    public static final String MEMBER_FILE = "menber.xml";
    //一开始，加载所有的商品
    public List<Product> prods = new ArrayList<>();

    {//构造块
        try {
            XMLDecoder xd = new XMLDecoder(new FileInputStream(FILE_NAME));
            prods = (List<Product>) xd.readObject();
            xd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //保存
    public void save(List<Product> p) {
        try {
            XMLEncoder xd = new XMLEncoder(new FileOutputStream(Action.FILE_NAME));
            xd.writeObject(p);
            xd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Member> members = new ArrayList<>();
    {
        try {
            XMLDecoder xd1 = new XMLDecoder(new FileInputStream(MEMBER_FILE));
            members = (List<Member>) xd1.readObject();
            xd1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveMember(List<Member> ms){
        try {
            XMLEncoder xd = new XMLEncoder(new FileOutputStream(MEMBER_FILE));
            xd.writeObject(ms);
            xd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public abstract Response execute(Request request);


}

