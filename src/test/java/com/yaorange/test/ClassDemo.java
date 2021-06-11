package com.yaorange.test;



class Circle {
	void display(){
		System.out.println("Circle");
    }
}
class Rectangle extends Circle {
	void display(){
		System.out.println("Rectangle");
    }
}
class Triangle extends Rectangle {
	void display(){
		System.out.println("Triangle");
    }
}
public class ClassDemo{
	public static void main(String args[]){
		(new Circle()).display();
		(new Rectangle()).display();(new 			Triangle()).display();
    }
}
