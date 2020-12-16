package project.common;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
//商品格式
public class WareInAction extends Action {
    public static final String FILE_NAME="products.xml";
    //一开始，加载所有的商品
    private List<Product> prods=new ArrayList<>();
    {//构造块
        try {
            XMLDecoder xd=new XMLDecoder(new FileInputStream(FILE_NAME));
            prods= (List<Product>) xd.readObject();
            xd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //保存
    public  void save(List<Product> p){
        try {
            XMLEncoder xd= new XMLEncoder(new FileOutputStream(WareInAction.FILE_NAME));
            xd.writeObject(p);
            xd.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
    @Override//增加数量
    public Response execute(Request request) {
        //
        String itemno=(String)request.get("no");
        int num=(Integer)request.get("num");
        //查找集合中商品号是否存在
        for(Product p:prods){
            if(p.getNo().equals(itemno)){
                //找到了
                p.setNum(p.getNum()+num);
                Response  response= new Response(true,"入库成功");
                response.put("products",prods);

                save(prods);
                return response;
            }
        }
        Response response=new Response(false,"没有此商品");
        response.put("products",prods);
        return response;
    }


    }



