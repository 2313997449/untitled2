package project.common;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WareFindsAction extends Action {
    public static final String FILE_NAME = "products.xml";
    //一开始，加载所有的商品
    private List<Product> prods = new ArrayList<>();

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
    public  void save(List<Product> p) {
        try {
            XMLEncoder xd = new XMLEncoder(new FileOutputStream(WareInAction.FILE_NAME));
            xd.writeObject(p);
            xd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override//查找商品
    public Response execute(Request request) {
         Response response= new Response(true,"开始查询");
                response.put("products",prods);
                return response;
    }
    }






