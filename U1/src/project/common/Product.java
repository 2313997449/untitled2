package project.common;

import java.io.Serializable;

public class Product implements Serializable {
    public static final long serialVersionUID = 71L;

    private String no,name,unit;
    private float price;
    private int num;

    public Product(){

    }

    public Product(String no, String name, String unit, float price, int num) {
        this.no = no;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.num = num;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
