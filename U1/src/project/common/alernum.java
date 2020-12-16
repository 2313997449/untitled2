package project.common;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class alernum extends Action {
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

    @Override
    public Response execute(Request request) {
        Response response;
        int num = (int) request.get("num");
        String no = (String) request.get("no");
        if (num > 0) {
            for (Product p : prods) {
                if (p.getNo().equals(no)) {

                }
            }
            response = new Response(true, "修改成功");
        } else {
            response = new Response(false, "数目错误");
        }
        return response;
    }
}


