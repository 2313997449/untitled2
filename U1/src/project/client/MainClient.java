package project.client;

import project.common.Member;
import project.common.Product;
import project.common.Request;
import project.common.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainClient {
    Socket s;
    private ObjectOutputStream oout;
    private ObjectInputStream oin;
    private Scanner sc = new Scanner(System.in);
    private List<Product> list = new ArrayList<>();
    private static String billNo = "100020";
    private String cashierName;
    private double integral;


    //初始化
    public MainClient(String ip, int port) {
        try {
            Socket s = new Socket(ip, port);
            oout = new ObjectOutputStream(s.getOutputStream());
            oin = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //负责发送和接受
    public Response send(Request request) throws Exception {
        oout.writeObject(request);
        oout.reset();
        Response resp = (Response) oin.readObject();

        return resp;
    }

    public void login() throws Exception {
        System.out.println("***********欢迎登录青鸟超市管理系统***********");
        System.out.println("1:登录，2：退出系统");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入密码:");
            String pass = sc.next();
            Request request = new Request("login");
            request.put("username", name);
            request.put("userpass", pass);

            Response resp = send(request);
            if (!resp.isSuccess()) {
                System.out.println("失败，原因是：" + resp.getMsg());
                login();
                return;
            } else if (resp.isSuccess()) {
                if (resp.getMsg().equals("admin")) {
                    showMenu();
                } else if (resp.getMsg().equals("control")) {
                    showNextMenu();
                }
            }

            // showMenu();
        } else if (choice == 2) {
            // System.exit(0);
            return;
        } else {
            System.out.println("输入错误");
            login();
        }

        showMenu();
    }

    public void showMenu() throws Exception {
        int choice = 0;
        while (true) {
            System.out.println("1:入库 2:出库 3：新增，4：查询 5：按照编号查询 6:退出");
            choice = sc.nextInt();
            if (choice == 1) {
                warein();
            } else if (choice == 2) {
                wareOut();
            } else if (choice == 3) {
                wareAdd();
            } else if (choice == 4) {
                wareFinds();
            } else if (choice == 5) {
                wareFind();
            } else if (choice == 6) {
                System.out.println("退出");
                return;
            }
        }
    }

    public void showBill(Member m, List<Product> list, double total, double money, String time) {
        String billTime = time.replace("-", "");
        System.out.println("            青鸟超市                  ");
        System.out.println("收银员：" + cashierName + "             小票号：" + (billNo));
        System.out.println("序号\t\t\t\t商品名称\t\t\t\t单价\t\t\t\t数量\t\t\t\t金额");
        System.out.println("---------------------------------------------------------------------------");
        int i = 1;
        int sumNum = 0;
        for (Product x : list) {
            sumNum += x.getNum();
            System.out.println(i++ + "\t\t\t" + "(" + x.getNo() + ")" + x.getName() + "\t\t\t"
                    + x.getPrice() + "\t\t\t\t" + x.getNum() + "\t\t\t\t" + x.getNum() * x.getPrice());
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("总数量：" + sumNum + "               应收：" + total);
        System.out.println("实收：" + money + "                  找零：" + (money - total));
        System.out.println("本次累计积分成功                 卡号：" + m.getMemberNo());
        System.out.println("消费前积分  +  本次消费积分  =  消费后积分");
        System.out.println(integral + "\t+\t" + (int) total + "\t=\t" + m.getIntegral());
        System.out.println(time);
        System.out.println("此小票是您退换货及核对积分的凭证，请妥善保存！");
        System.out.println("============================================================================");
    }

    public void showBill(List<Product> list, double total, double money, String time) {
        String billTime = time.replace("-", "");
        System.out.println("            青鸟超市                  ");
        System.out.println("收银员：" + cashierName + "             小票号：" + (billNo));
        System.out.println("序号\t\t\t\t商品名称\t\t\t\t单价\t\t\t\t数量\t\t\t\t金额");
        System.out.println("---------------------------------------------------------------------------");
        int i = 1;
        int sumNum = 0;
        for (Product x : list) {
            sumNum += x.getNum();
            System.out.println(i++ + "\t\t\t" + "(" + x.getNo() + ")" + x.getName() + "\t\t\t"
                    + x.getPrice() + "\t\t\t\t" + x.getNum() + "\t\t\t\t" + x.getNum() * x.getPrice());
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("总数量：" + sumNum + "               应收：" + total);
        System.out.println("实收：" + money + "                  找零：" + (money - total));
        System.out.println(time);
        System.out.println("此小票是您退换货及核对积分的凭证，请妥善保存！");
        System.out.println("============================================================================");
    }

    public void printMenu(List<Product> p){
        System.out.println("编号\t\t\t\t名称\t\t\t\t单价\t\t\t\t数量\t\t\t\t金额");
        System.out.println("---------------------------------------------------------------------------");
        for (Product x : p) {
            System.out.println(x.getNo() + "\t\t\t" + x.getName() + "\t\t\t"
                    + x.getPrice() + "\t\t\t\t" + x.getNum() + "\t\t\t\t" + x.getNum() * x.getPrice());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public void showNextMenu() throws Exception {
        int choice = 0;
        while (true) {
            System.out.println("*********欢迎登录青鸟超市收银系统*********");
            System.out.println("请选择要进行的操作: 1.扫描商品 2.修改数量 3.结账 4.退出");
            choice = sc.nextInt();
            if (choice == 1) {
                scanning();
            } else if (choice == 2) {
                if (!list.isEmpty()) {
                    modifiNum();
                } else {
                    System.out.println("请先扫描商品");
                }
            } else if (choice == 3) {
                checkOut();
            } else if (choice == 4) {
                System.out.println("退出");
                return;
            }
        }
    }

    //扫描
    public void cashierScan() throws Exception {
        Response response = null;
        boolean isrun = true;
        while (isrun) {
            System.out.println("扫描商品号：");
            String no = sc.next();
            System.out.println("扫描次数：");
            int num = 0;
            while (true) {
                num = sc.nextInt();
                if (num > 0)
                    break;
                System.out.println("输入错误，重来");
            }

            Request request = new Request("cashierScan");
            request.put("no", no);
            request.put("num", num);

            response = send(request);//第六步 将服务器发过来的信息进行解析
            if (response.isSuccess()) {
                System.out.println(response.getMsg());
                Product product = (Product) response.get("product");
                System.out.println("购物车中的商品:" + product.getNo() + product.getName() + product.getPrice());
                System.out.println("扫描完毕，请按1  继续扫描请按2");
                int str = sc.nextInt();
                if (str == 0) {
                    isrun = false;
                } else if (str == 2) {
                    cashierScan();
                }
            } else {
                System.out.println("" + response.getMsg() + "出错");
            }
        }

    }

    //海强 修改数目
    public void scanning() throws Exception {
        System.out.println("输入要扫描的商品编号：");
        String no = sc.next();
        Request request = new Request("scan");
        request.put("no", no);
        request.put("list", list);
        Response response = send(request);
        if (response.isSuccess()) {
            System.out.println(response.getMsg());
            list = (List<Product>) response.get("list");
            //printMenu(list);
        } else {
            System.out.println(response.getMsg());
        }
    }


    //结账
    public void checkOut() throws Exception {
        Request request = new Request("check");
        request.put("list", list);
        Response response = send(request);
        if (response.isSuccess()) {
            System.out.println("总金额为：" + response.get("total"));
            System.out.println("1.普通结账2.会员结账");
            int choise = sc.nextInt();
            if (choise == 1) {
                commonCheck((Double) response.get("total"));
            } else if (choise == 2) {
                memberCheck((Double) response.get("total"));
            } else {
                System.out.println("非法输入！");
                checkOut();
            }
        } else {
            System.out.println(response.getMsg());
        }
    }

    public void alernum() throws Exception {
        System.out.println("请输入需要修改的商品的编码：");
        String no = sc.next();
        System.out.println("输入修改后的数量：");
        int num = 0;
        num=sc.nextInt();
        Request request = new Request("alernum");
        request.put("num",num);
        request.put("no",no);
        Response response = send(request);
        if (response.isSuccess()){
            System.out.println("修改成功");
        }else {
            System.out.println(response.getMsg());
        }

       }

    public int inputNum() {
        int num = 0;
        while (true) {
            num = sc.nextInt();
            if (num > 0)
                break;
            System.out.println("输入错误，重来");
        }
        return num;
    }



    public void modifiNum() throws Exception {
        System.out.println("输入要修改的商品编号：");
        String no = null;
        a:
        while (true) {
            no = sc.next();
            for (Product p : list) {
                if (p.getNo().equals(no)) {
                    break a;
                }
            }
            System.out.println("没有扫描次商品！");
        }
        System.out.println("输入修改数量：");
        int num = inputNum();
        Request request = new Request("modifiNum");
        request.put("no", no);
        request.put("num", num);
        request.put("productList", list);
        Response response = send(request);
        if (response.isSuccess()) {
            list = (List<Product>) response.get("products");
            printMenu(list);
        } else {
            System.out.println(response.getMsg());
        }
    }



    public void commonCheck(double total) throws Exception {
        double money = inputMoney();
        Request request = new Request("common");
        request.put("money", money);
        request.put("total", total);
        request.put("list", list);
        Response response = send(request);
        if (response.isSuccess()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMddHHmmss");
            billNo = billNo + sdf1.format((Date) response.get("sdf"));
            String time = sdf.format((Date) response.get("sdf"));
            list = (List<Product>) response.get("list");
           showBill(list, total, money, time);
            list.clear();
        } else {
            System.out.println(response.getMsg());
        }
    }

    public double inputMoney() {
        System.out.println("请输入您要支付的金额：");
        double money = 0;
        while (true) {
            try {
                money = sc.nextDouble();
                if (money >= 0) {
                    break;
                } else {
                    System.out.println("请输入正确的金额！");
                }
            } catch (Exception e) {
                System.out.println("请确认输入的是金额！");
                sc.nextLine();
            }
        }
        return money;
    }


    public void memberCheck(double total) throws Exception {
        System.out.println("请输入您的会员卡号：");
        String cardNo;
        while (true) {
            cardNo = sc.next();
            Request request = new Request("cardNo");
            request.put("cardNo", cardNo);
            Response response = send(request);
            if (response.isSuccess()) {
                System.out.println(response.getMsg());
                break;
            } else {
                System.out.println(response.getMsg());
            }
        }
        double money = inputMoney();
        Request request = new Request("member");
        request.put("money", money);
        request.put("total", total);
        request.put("list", list);
        request.put("cardNo", cardNo);
        Response response = send(request);
        if (response.isSuccess()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMddHHmmss");
            billNo = billNo + sdf1.format((Date) response.get("sdf"));
            String time = sdf.format((Date) response.get("sdf"));
            list = (List<Product>) response.get("list");
            Member m = (Member) response.get("member");
            integral = (double) response.get("integral");
            showBill(m, list, total, money, time);
            list.clear();
        } else {
            System.out.println(response.getMsg());
        }
    }


    //入库
    public void warein() throws Exception {
        System.out.println("入库商品号：");
        String no = sc.next();
        System.out.println("入库数量：");
        int num = 0;
        while (true) {
            num = sc.nextInt();
            if (num > 0)
                break;
            System.out.println("输入错误，重来");
        }
        Request request = new Request("wareIn");
        request.put("no", no);
        request.put("num", num);
        Response response = send(request);
        if (response.isSuccess()) {
            System.out.println("入库成功");
        } else {
            System.out.println("入库失败，" + response.getMsg() + ",请选择2，新增商品");
        }
        //当前存在的商品
        List<Product> prods = (List<Product>) response.get("products");
        System.out.println("编号  名称    单价    单位    数量  ");
        prods.stream().forEach(x -> {
            System.out.println(x.getNo() + " " + x.getName() + " " + x.getPrice() + " " + x.getUnit() + " " + x.getNum());
        });
    }

    public void wareOut() throws Exception {
        System.out.println("出库商品号：");
        String no = sc.next();
        System.out.println("出库数量：");
        int num = 0;
        while (true) {
            num = sc.nextInt();
            if (num > 0)
                break;
            System.out.println("输入错误，重来");
        }
        Request request = new Request("wareOut");
        request.put("no", no);
        request.put("num", num);
        Response response = send(request);
        if (response.isSuccess()) {
            System.out.println("出库成功");
        } else {
            System.out.println("出库失败，" + response.getMsg() + ",请选择2，重选商品");
        }
        //当前存在的商品
        List<Product> prods = (List<Product>) response.get("products");
        System.out.println("编号  名称    单价    单位    数量  ");
        prods.stream().forEach(x -> {
            System.out.println(x.getNo() + " " + x.getName() + " " + x.getPrice() + " " + x.getUnit() + " " + x.getNum());
        });
    }

    public void wareAdd() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品编码：");
        String no = sc.next();
        System.out.print("请输入商品数量：");
        int num = sc.nextInt();
        System.out.println("请输入商品名称");
        String name = sc.next();
        System.out.println("请输入商品单位");
        String unit = sc.next();
        System.out.println("请输入商品价格");
        float price = sc.nextFloat();
        Request request = new Request("wareAdd");
        request.put("no", no);
        request.put("num", num);
        request.put("name", name);
        request.put("unit", unit);
        request.put("price", price);
        Response response = send(request);
        if (response.isSuccess()) {
            System.out.println(response.getMsg());
        } else {
            System.out.println("" + response.getMsg() + "");
        }
        //当前存在的商品
        List<Product> prods = (List<Product>) response.get("products");
        System.out.println("编号  名称    单价    单位    数量  ");
        prods.stream().forEach(x -> {
            System.out.println(x.getNo() + " " + x.getName() + " " + x.getPrice() + " " + x.getUnit() + " " + x.getNum());
        });
    }


//    public void beltway() throws Exception {
//        if (prods.isEmpty()) {
//            System.out.println("请先扫描商品");
//            return;
//        }
//        Request request = new Request("beltway");
//        request.put("list", list);
//        Response response = send(request);
//        if (response.isSuccess()) {
//            System.out.println("总金额：" + response.get("money"));
//            int choice = 0;
//            while (true) {
//                System.out.println("1.普通结账   2.会员结账");
//                choice = sc.nextInt();
//                if (choice == 1) {
//                    commonCustom();
//                }
//                if (choice == 2) {
//                    wareout();
//                }else {
//                    break;
//                }
//            }
//        } else {
//            System.out.println("修改失败，" + response.getMsg());
//        }
//    }

    public void wareFind() throws Exception {
//        System.out.println("请选择单项还是全部查询" + "1.单项 2.全部");
//        int coo = sc.nextInt();
//        Request request = null;
//        if (coo == 1) {
//            request = new Request("wareFind");
//            System.out.println("请输入商品编号");
//            int num = sc.nextInt();
//            request.put("num", num);
//            request.put("co", coo);
//            Response response = send(request);
//            if (response.isSuccess()) {
//                List<Product> prods = (List<Product>) response.get("products");
//                System.out.println("" + response.getMsg() + "");
//                int ss = Integer.parseInt(response.getco());
//                prods.get(ss);
//            }
       // }
        System.out.println("查找商品号：");
        String no = sc.next();
        Request request = new Request("wareFind");
        request.put("no", no);
        Response response = send(request);
        if (response.isSuccess()) {
            System.out.println("查找成功");
          Product product =  (Product) response.get("product");
            System.out.println("编号  名称    单价    单位    数量  ");
            System.out.println(product.getName()+product.getNo()+product.getUnit()+product.getPrice());
        } else {
            System.out.println("查找失败，" + response.getMsg() + ",请选择5，重新输入");
        }
    }

        public void wareFinds() throws Exception {

            Request request = new Request("wareFinds");
            Response response = send(request);
            //当前存在的商品
            List<Product> prods = (List<Product>) response.get("products");
            System.out.println("编号  名称    单价    单位    数量  ");
            prods.stream().forEach(x -> {
                System.out.println(x.getNo() + " " + x.getName() + " " + x.getPrice() + " " + x.getUnit() + " " + x.getNum());
            });
        }
    //关闭网络流
        public void close () {
            if (s != null && !s.isClosed()) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main (String[]args){
            MainClient m = new MainClient("localhost", 9999);
            try {
                m.login();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("系统关闭，退出");
                m.close();
            }
        }
    }
