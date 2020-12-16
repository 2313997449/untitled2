package project.common;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InitInfo {
    public static void main(String[] args) throws Exception {
        //初始化几个商品信息
        List<Product> prods=new ArrayList<>();
        prods.add(new Product("1000","恰恰瓜子","袋",4.5F,80));
        prods.add(new Product("1001","可口可乐","瓶",3.5F,100));
        prods.add(new Product("1002","卫龙辣条","袋",9.5F,55));
        prods.add(new Product("1003","相印纸巾","包",4.5F,60));
        prods.add(new Product("1004","农夫山泉","瓶",2F,100));
        prods.add(new Product("1005","百事可乐","瓶",3F,100));
        XMLEncoder xd= new XMLEncoder(new FileOutputStream(Action.FILE_NAME));
        xd.writeObject(prods);
        xd.close();
        System.out.println("商品信息写入完成");
        //初始化会员中心
        List<Member> members = new ArrayList<>();
        members.add(new Member("100001",500));
        members.add(new Member("100002",200));
        members.add(new Member("100003",1000));
        members.add(new Member("100004",50));
        XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("menber.xml"));
        xmlEncoder.writeObject(members);
        xmlEncoder.close();
        System.out.println("会员信息写入完成！");
    }
}
