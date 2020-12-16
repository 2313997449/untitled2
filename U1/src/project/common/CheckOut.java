package project.common;

import project.common.Product;
import project.common.Request;
import project.common.Response;


import java.util.List;

public class CheckOut extends Action {
    @Override
        public Response execute(Request request) {
            List<Product> list = (List<Product>) request.get("list");
            double total = 0;
            for (Product p : list) {
                total += p.getNum() * p.getPrice();
            }
            Response response = new Response(true);
            response.put("total", total);
            return response;
        }
    }
