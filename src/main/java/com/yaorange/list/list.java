package com.yaorange.list;

import java.util.ArrayList;

/**
 * @ClassName list
 * @Description TODO
 * @Auther elsfk
 * @Date2021/8/10 14:04
 * @Version 1.0
 **/
public class list {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(0));
    }
}
