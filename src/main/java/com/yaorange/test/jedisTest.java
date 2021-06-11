package com.yaorange.test;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName jedisTest
 * @Description TODO
 * @Auther elsfk
 * @Date2021/5/18 16:22
 * @Version 1.0
 **/

public class jedisTest {

    public void jedisClient(){
        Jedis jedis= new Jedis("192.168.29.8",6379);
        jedis.set("s2","222");
        String s2 = jedis.get("s2");
        System.out.println(s2);
        jedis.close();
    }
    public void jedispool(){
        JedisPool jedisPool=new JedisPool("192.168.29.8",6379);
        Jedis jedis=jedisPool.getResource();
        jedis.set("s3","22222");
        String s2 = jedis.get("s3");
        System.out.println(s2);
        jedis.close();
        jedisPool.close();
    }

    public static void main(String[] args) {
        jedisTest jedisTest = new jedisTest();
        jedisTest.jedisClient();
        jedisTest.jedispool();
    }

}
