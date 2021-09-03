package com.yaorange.test;

/**
 * @ClassName ten
 * @Description TODO
 * @Auther elsfk
 * @Date2021/6/30 11:19
 * @Version 1.0
 **/
public class ten {
    public static void main(String[] args) {
        double a=100;
        double b=0;
        for (int i = 0; i <10 ; i++) {
            b=a+b;
            a=a/2;
        }
        System.out.println( b);
        System.out.println(a);
    }
}
