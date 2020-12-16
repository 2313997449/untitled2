package project.common;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

//商品格式
public class WareOutAction extends Action {
    public static final String FILE_NAME="products.xml";
    //一开始，加载所有的商品
    @Override
    public Response execute(Request request) {
        String itemno=(String)request.get("no");
        int num=(Integer)request.get("num");
        //查找集合中商品号是否存在
        Response  response = null;
        for(Product p:prods){
            if(p.getNo().equals(itemno)){
                //找到了
                if((p.getNum()-num) >= 0){
                    p.setNum(p.getNum()-num);
                    response = new Response(true,"出库成功");
                    response.put("products",prods);
                    super.save(prods);
                }else {
                    response=new Response(false,"库存不够");
                    response.put("product",p);
                }
            }
        }
        return response;
    }
}
