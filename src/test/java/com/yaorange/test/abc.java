package com.yaorange.test;

public class abc {
		void test(int i){
		System.out.println("int");
		}
		void test(String s){
		System.out.println("String");
		}
		public static void main(String args []){
		abc a = new abc();
		char ch = 'A';
		a.test(ch);
		}
		}
