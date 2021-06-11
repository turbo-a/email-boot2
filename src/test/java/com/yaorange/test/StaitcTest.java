package com.yaorange.test;

class StaitcTest{
    static int x = 1;
    int y ;
    void StaticTest(){
        y++;
    }
    public static void main(String args []){
        StaitcTest st = new StaitcTest();
        System.out.println("x=" + x);
        System.out.println("st.y=" + st.y);
        st =new  StaitcTest();
        System.out.println("st.y="+ st.y);
    }
    static{
        x++;
    }
}
