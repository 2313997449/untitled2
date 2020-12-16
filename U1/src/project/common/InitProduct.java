package project.common;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class InitProduct {
    public static void main(String[] args) throws FileNotFoundException {
        //初始化几个商品信息
        List<Product> prods=new ArrayList<>();
        prods.add(new Product("1000","恰恰瓜子","袋",4.5F,80));
        prods.add(new Product("1001","可乐","瓶",3.5F,100));

        prods.add(new Product("1002","卫龙辣条","袋",9.5F,55));

        XMLEncoder xd= new XMLEncoder(new FileOutputStream(WareInAction.FILE_NAME));
        xd.writeObject(prods);
        xd.close();
    }
}
