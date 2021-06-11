package com.yaorange.test;

class MyThread extends Thread
{
    public void run()
    {
        try{
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("I am alve");
    }
}
public class MyProgram {
    public static void main(String args[]) {
        char[] chars = new char[5];
        chars[0]='h';
        chars[1]='h';
        chars[2]='h';
        chars[3]='h';
        chars[4]='h';
        System.out.println(chars);
        new MyThread().start();
            int arr[] = new int[20];
            arr[20]=1237;

    }
}
