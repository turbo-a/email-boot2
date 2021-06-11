package com.yaorange.test;

/**
 * @ClassName Treee
 * @Description TODO
 * @Auther elsfk
 * @Date2021/5/19 9:42
 * @Version 1.0
 **/
class Tree {
}
class Pine extends Tree {
}

class Oak extends Tree {
}


 class Forest {
    public static void main(String[] args) {

        Tree tree = new Pine();
        if (tree instanceof Pine)
            System.out.println("Pine");
        if (tree instanceof Tree)
            System.out.println("Tree");
        if (tree instanceof Oak)
            System.out.println("Oak");
        else System.out.println("Oops");
    }
}
