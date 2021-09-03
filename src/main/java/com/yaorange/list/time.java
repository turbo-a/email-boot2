package com.yaorange.list;

import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName time
 * @Description TODO
 * @Auther elsfk
 * @Date2021/8/17 16:42
 * @Version 1.0
 **/
public class time {
    public static void main(String[] args) {
        System.out.println("原时间 " + new Date());

        TimeZone time = TimeZone.getTimeZone("Etc/GMT");  //转换为中国时区

        TimeZone.setDefault(time);

        System.out.println("修改后时间 " + new Date());

    }
}
