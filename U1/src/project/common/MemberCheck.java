package project.common;

import java.util.Date;
import java.util.List;

public class MemberCheck extends Action {
    @Override
    public Response execute(Request request) {
        double money = (double) request.get("money");
        double total = (double) request.get("total");
        String cardNo = (String) request.get("cardNo");
        List<Product> list = (List<Product>) request.get("list");
        if(money >= total){
            for(Product p : prods){
                for (Product p1 : list){
                    if(p.getNo().equals(p1.getNo())){
                        p.setNum(p.getNum()-p1.getNum());
                        break;
                    }
                }
            }
            save(prods);
            Response response = new Response(true,"结账成功");
            for (Member m : members){
                if(m.getMemberNo().equals(cardNo)){
                    response.put("integral",m.getIntegral());
                    m.setIntegral(m.getIntegral()+(int)total);
                    response.put("member",m);
                    break;
                }
            }
            saveMember(members);
            response.put("list",list);
            response.put("sdf",new Date());
            return response;
        }
        return new Response(false,"本次支付金额不够，请重新支付！");
    }
}
