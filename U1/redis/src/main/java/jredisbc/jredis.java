package jredisbc;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class jredis {

        public static void main(String[] args){
            str();
        }

        public static void str() {
            //连接本地的 Redis 服务
            Jedis jedis = new Jedis("localhost");
            System.out.println("连接成功");
            //设置 redis 字符串数据
            jedis.set("runoobkey", "www.runoob.com");
            // 获取存储的数据并输出
            System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
            Subject sj = new Subject();
            sj.setSubjectname("javs");
            sj.setClasshour(15);
            sj.setGradeid(12);
            sj.setId(21);




        }

    public static void lis( ) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }


        public static void show() {
            //连接本地的 Redis 服务
            Jedis jedis = new Jedis("localhost");
            System.out.println("连接成功");

            // 获取数据并输出
            Set<String> keys = jedis.keys("*");
            Iterator<String> it=keys.iterator() ;
            while(it.hasNext()){
                String key = it.next();
                System.out.println(key);
            }
        }





    }

