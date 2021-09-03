package com.yaorange.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName map
 * @Description TODO
 * @Auther elsfk
 * @Date2021/7/1 14:40
 * @Version 1.0
 **/
public class map {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("insert into table (" + entry.getKey() + ") Value (" + entry.getValue()+")");
        }
    }
}
