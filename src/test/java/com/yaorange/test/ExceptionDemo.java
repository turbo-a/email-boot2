package com.yaorange.test;

class MyException extends Exception{
	public String toString0(){
		return "negative";
    }
}
public class ExceptionDemo {
	public static void mySqrt(int a) throws MyException {
		if (a < 0) {
			System.out.println(Math.sqrt(a));
			throw new MyException();
		}
	}

	public static void main(String args[]) {
		try {
			mySqrt(25);
			mySqrt(-5);
			mySqrt(16);
		} catch (MyException e) {
			System.out.println("Caught " + e);
		}
	}
}
