package XML.G;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadXMLPro {
    public static void main(String[] args) throws IOException, DocumentException, SAXException, ParserConfigurationException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new FileInputStream("src/XML/products.xml"));
        Element root = document.getRootElement();
        System.out.println(root);//获取根节点

        List<Element> list = root.elements();
        for (Element e : list) {
            System.out.println(e.getName());
        }

        Element contactElem = root.element("product");
        List<Element> contactList = contactElem.elements();
        for (Element e: contactList) {
            System.out.println(e.getName());
       }
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");


        //  find(document);
      //  System.out.println("商品目录");
        //readMune(document);
        buy(document);
       // add(document);
        System.out.println("--------------");



    }
    public static void find(Document document) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找商品的编号：");
        String item = sc.next();
        Element e = (Element) document.selectSingleNode("/shop/product[itemno=" + item + "]");
        if (e == null) {
            System.out.println("没有找到！");
            return;
        }
        show(e);
        System.out.println("----------查找成功----------");
    }
    public static void readMune(Document document) {
        Element root = document.getRootElement();
        System.out.println(root.attribute(0).getText());
        List<Element> products = root.selectNodes("product");
        for (Element e : products) {
            show(e);
            System.out.println("--------------------");
        }
    }

    public static void show(Element e) {
        System.out.println("折扣:" + e.attributeValue("discount") + "---工厂地址:" + e.attributeValue("factoryaddr"));
        Element eItemno = (Element) e.selectSingleNode("itemno");
        System.out.println("itemno:" + eItemno.getText());
        Element eName = (Element) e.selectSingleNode("name");
        System.out.println("name:" + eName.getText());
        Element ePrice = (Element) e.selectSingleNode("price");
        System.out.println("price:" + ePrice.getText());
        Element eStockcount = (Element) e.selectSingleNode("stockcount");
        System.out.println("stockcount:" + eStockcount.getText());
        Element eUnit = (Element) e.selectSingleNode("unit");
        System.out.println("unit:" + eUnit.getText());
    }

    public static void add(Document document) throws ParserConfigurationException, IOException, SAXException, DocumentException {
        /*
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("src/XML/products.xml");
        用的是org.w3c.dom.NodeList方法
         */
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(new FileInputStream("src/XML/products.xml"));
        Element root = document.getRootElement();
/*
        Element product = root.addElement("product");
        product.addAttribute("discount", discount);
        product.addAttribute("factoryaddr", factoryaddr);
        product.addElement("itemno").addText(String.valueOf(itemno));
        product.addElement("name").addText(name);
        product.addElement("price").addText(String.valueOf(price));
        product.addElement("stockcount").addText(String.valueOf(count));
        product.addElement("unit").addText(unit);
*/
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        boolean isHave = false;
            Scanner sc = new Scanner(System.in);
            System.out.println("discount--factoryaddr--itemno--name--price--stockcount--unit");
            String discount = sc.next();
            String factoryaddr = sc.next();
            int itemno = sc.nextInt();
            String name = sc.next();


        //获取根节点

        List<Element> list = root.elements();

            for (Element e : list) {
                System.out.println(e.getName());
                Element eName = (Element) e.selectSingleNode("name");
                if (!isHave) {
                    if (name.equals(eName)) {
                        isHave = true;
                        System.out.println("商品已存在");
                    } else {
                        System.out.println("输入正确");
                    }
                }

            }

            double price = sc.nextDouble();
            int count = sc.nextInt();
            String unit = sc.next();
            Element product = root.addElement("product");
            product.addAttribute("discount", discount);
            product.addAttribute("factoryaddr", factoryaddr);
            product.addElement("itemno").addText(String.valueOf(itemno));
            product.addElement("name").addText(name);
            product.addElement("price").addText(String.valueOf(price));
            product.addElement("stockcount").addText(String.valueOf(count));
            product.addElement("unit").addText(unit);
            write(document);
            System.out.println("添加成功！");
        }


    public static void write(Document document){
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("utf-8");
        try {
            XMLWriter xw = new XMLWriter(new FileWriter("src\\XML\\products.xml"));
            xw.write(document);
            xw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void modifi(Document document) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找商品的编号：");
        String item = sc.next();
        Element e = (Element) document.selectSingleNode("/shop/product[itemno=" + item + "]");
        if (e == null) {
            System.out.println("没有找到！");
            return;
        }
        System.out.println("请输入要修改的商品价格：");
        String count = sc.next();
        e.selectSingleNode("price").setText(count);
        write(document);
        System.out.println("修改成功！");
    }
    public static void del(Document document) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除商品的编号：");
        String item = sc.next();
        Element e = (Element) document.selectSingleNode("/shop/product[itemno=" + item + "]");
        if (e == null) {
            System.out.println("没有找到！");
            return;
        }
        e.getParent().remove(e);
        write(document);
        System.out.println("删除成功！");
    }
    /*
    以products.xml作为基础，实现客户购买的方法，输入商品号和购买数量，计算应付金额，如果是折扣商品，打七折；
    如果购买数量超过库存量，给出提示；商品不存在，给出提示；购买成功，扣除相应的数量。最后输出应付款的金额。
     */

    public static void buy(Document document){
        System.out.println("欢迎光临");
        System.out.println("商品目录");
        readMune(document);
        boolean isExit = true;
        double countNum = 0.00;
        double nprice = 0.00;
        int ecount = 0;
        int count =0;
        boolean discount;
        while (isExit) {
            System.out.println("请输入商品号");
            Scanner in = new Scanner(System.in);
            int item = in.nextInt();
            System.out.println("请输入商品数量");
           // Element e =(Element) document.selectSingleNode("shop/product/[itemno="+eitemon+"]");
            Element e = (Element) document.selectSingleNode("/shop/product[itemno=" + item + "]");
            Element ePrice = (Element) e.selectSingleNode("price");
            nprice =Double.parseDouble(ePrice.getText());
            System.out.println(nprice);
            Element eStockcount = (Element) e.selectSingleNode("stockcount");
            ecount = Integer.parseInt(eStockcount.getText());
            count = in.nextInt();
            countNum = countNum +countNum;
            countNum = count*nprice;
            System.out.println(count);
            System.out.println("是否继续购买商品:1.退出 2.继续");
            int i = in.nextInt();
            if (i == 1){
                isExit = false;
            }else {
                isExit = true;
            }
        }
        System.out.println("欢迎下次光临");
        System.out.println("支付价格为"+countNum);
        modifi(document);


    }



    }







