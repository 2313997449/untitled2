package controlMessage;

import XML.G.ReadXML;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class ReadL {
    public static void main(String[] args) {
        // String path = Document.class.getClassLoader().getResource("DateStidengCeng.xml").getPath();
        //  System.out.println(path);
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(ReadL.class.getClassLoader().getResourceAsStream("DateStidengCeng.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
            //   document =  DocumentHelper.createDocument();
            // document.addElement("Students");

        }
        Element list = document.getRootElement();
//        // System.out.println((list.selectNodes(0)).getTex());\
//        System.out.println(list.attribute(0).getText());
        List<Element> Students = list.selectNodes("student");
        for (Element s : Students) {
            show1(s);
            System.out.println("--------------------");


        }

     }

    public static void show1(Element s) {
        System.out.println(s.attributeValue("id"));
        Element eName = (Element) s.selectSingleNode("name");
        System.out.println("name:" + eName.getText());
        Element eSex = (Element) s.selectSingleNode("Sex");
        System.out.println("price:" + eSex.getText());
        Element eAge = (Element) s.selectSingleNode("age");
        System.out.println("stockcount:" + eAge.getText());
    }

}
