package project.common;

import project.common.Product;
import project.common.Request;
import project.common.Response;

import java.util.List;

public class Scanning extends Action {
    @Override
    public Response execute(Request request) {
        String no = (String) request.get("no");
        List<Product> list = (List<Product>) request.get("list");
        for (Product p : list){
            if(p.getNo().equals(no)){
                return new Response(false,"该商品已扫描，如还需添加请选择2.修改数量!");
            }
        }
        for(Product p : prods){
            if(p.getNo().equals(no)){
                p.setNum(1);
                list.add(p);
                Response response = new Response(true,"扫描成功！");
                response.put("list",list);
                return response;
            }
        }
        return new Response(false,"对不起，没有该商品，扫描失败！");
    }
}
