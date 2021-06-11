package com.yaorange.test;

/**
 * @ClassName test
 * @Description TODO
 * @Auther elsfk
 * @Date2021/5/11 9:23
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) {
        String str="aaa";
        set(str);
        System.out.println(str);
    }
    private static void set(String s){
        s="bbb";
        System.out.println(s);
    }
}
