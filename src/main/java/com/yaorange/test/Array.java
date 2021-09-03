package com.yaorange.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Array
 * @Description TODO
 * @Auther elsfk
 * @Date2021/7/1 14:07
 * @Version 1.0
 **/
public class Array {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(3);
        list.add(1);
        int[] ints = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            ints[i]=list.get(i);
        }
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);

        }
        for (int i = 0; i <ints.length ; i++) {
            for (int j = 0; j <ints.length-i-1; j++) {
                if (ints[j]>ints[j+1]){
                    int tmp=ints[j];
                    ints[j]=ints[j+1];
                    ints[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);

        }
    }
}
