package project.common;

import java.util.List;

public class ModifiNum extends Action {
    @Override
    public Response execute(Request request) {
        String no = (String) request.get("no");
        int num = (int) request.get("num");
        List<Product> list = (List<Product>) request.get("productList");
        for (Product p : prods){
            if(p.getNo().equals(no)){
                if(p.getNum() >= num){
                    p.setNum(p.getNum()-num);
                }else {
                    return new Response(false,"库存不足！");
                }
            }
        }
        for(Product p : list){
            if(p.getNo().equals(no)){
                p.setNum(num);
                Response response = new Response(true,null);
                response.put("products",list);
                return response;
            }
        }
        return new Response(false,"修改失败！");
    }
}
