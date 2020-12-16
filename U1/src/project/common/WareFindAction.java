package project.common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.lang.model.util.Elements;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WareFindAction extends Action {
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
        //
        Response response = new Response();

//        int num = (Integer) request.get("num");
//        if (num == 1) {
//
//            String co = (String) request.get("co");
//            for (Product p : prods) {
//                if (p.getNo().equals(co)) {
//                   String ss= String.valueOf(prods.indexOf(co)) ;
//                    response = new Response(true,"商品已找到",ss);
//
//                }
//            }
//        } else if (num == 2) {
//            for (Product p : prods) {
//                System.out.println(p);
//                response = new Response(true,"商品已输出");
//               ;
//
//            }
//        } else {
//             response = new Response(false, "没有此商品");
//            response.put("products", prods);
//        }
        String itemno=(String)request.get("no");
        //查找集合中商品号是否存在
        for(Product p:prods){
            if(p.getNo().equals(itemno)){
                //找到了
                 response= new Response(true,"查找成功");
                response.put("product",p);
                return response;
            }
        }
        return response;
    }

}




