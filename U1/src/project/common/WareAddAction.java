package project.common;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WareAddAction extends Action {
    public static final String FILE_NAME = "products.xml";
    //一开始，加载所有的商品


    private List<Product> prods = new ArrayList<>();
    private Object String;

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

    @Override
    public Response execute(Request request) {
        //
        Response response = null;
        String no = (String) request.get("no");
        String name = (String) request.get("name");
        String unit = (String) request.get("unit");
        float price = (float) request.get("price");
        int num = (int) request.get("num");
        prods.add(new Product(no, name, unit, price, num));
        boolean have;
        have = prods.contains(new Product(no, name, unit, price, num));
         if (have) {
             save(prods);
             response = new Response(true, "成功");
             response.put("products", prods);
         }
        return response;
    }
}






