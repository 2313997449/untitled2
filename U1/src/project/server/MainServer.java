package project.server;


import  project.common.*;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(9999);
            ExecutorService es = Executors.newCachedThreadPool();
            System.out.println("监听在9999端口");
            while (true) {
                Socket sk =    socket.accept();
                System.out.println(sk + "连接成功");
                es.execute(() -> {
                    Socket s = sk;
                    ObjectInputStream oin = null;
                    ObjectOutputStream oout = null;
                    try {
                        //从客户端拿一个信息，然后回复
                        InputStream in = s.getInputStream();
                        OutputStream out = s.getOutputStream();
                        oin = new ObjectInputStream(in);
                        oout = new ObjectOutputStream(out);
                        while (true) {
                            //从请求中拿到Request对象，表明要干嘛   //第二步
                            Request request = (Request) oin.readObject();
                            Action action = null;

                            //根据action属性，确定要干嘛
                            //创建对应的实现类
                            if (request.getAction().equals("login")) {
                                action = new LoginAction();
                            }else if(request.getAction().equals("wareIn"))
                            {
                                action=new WareInAction();
                            }
                            else if(request.getAction().equals("byebye")){

                            }else  if (request.getAction().equals("wareOut")) {
                                action = new WareOutAction();
                            }else if (request.getAction().equals("wareAdd")){
                                action = new WareAddAction();
                            }else if (request.getAction().equals("wareFind")){
                                action = new WareFindAction();
                            }else if (request.getAction().equals("wareFinds")){
                                action = new WareFindsAction();
                            } else if (request.getAction().equals("scan")) {
                                action = new Scanning();
                            } else if (request.getAction().equals("check")) {
                                action = new CheckOut();
                            } else if (request.getAction().equals("common")) {
                                action = new CommonCheck();
                            } else if (request.getAction().equals("modifiNum")) {
                                action = new ModifiNum();
                            } else if (request.getAction().equals("cardNo")) {
                                action = new CardNo();
                            } else if (request.getAction().equals("member")) {
                                action = new MemberCheck();
                            } else if (request.getAction().equals("exit")) {
                                Response result = new Response(true, "欢迎下次使用！");
                             result = new Response(true, "欢迎下次使用！");
                                //发送给客户端
                                oout.writeObject(result);
                                oout.reset();
                                System.out.println(sk.getInetAddress() + "退出连接！");
                                break;
                            }
                            //执行，获得对应的返回response
                            Response result = action.execute(request);
                            //发送给客户端
                            oout.writeObject(result);
                            oout.reset();//重置
                        }
                    } catch (Exception e) {
                        System.out.println(s + "出错了。。。" + e);
                        //e.printStackTrace();
                        if (s.isConnected()) {
                            Response result = new Response(false, "错误信息：" + e.getMessage());
                            try {
                                oout.writeObject(result);
                                oout.reset();
                            } catch (IOException e1) {

                            }
                        }
                    } finally {
                        if (s != null && !s.isClosed()) {
                            try {
                                s.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("启动失败：" + e);
            return;
        }
    }
}
