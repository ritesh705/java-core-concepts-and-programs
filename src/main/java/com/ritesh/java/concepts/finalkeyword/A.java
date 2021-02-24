package com.ritesh.java.concepts.finalkeyword;

class B {
	static final int maxspeed;
	final void run(){
		int speed = 60;
		System.out.println(speed);
	}
	void display(){
		System.out.println(maxspeed);
	}
	static {
		maxspeed = 100;
	}
}
public class A extends B{
	/*void run(){
		System.out.println("Method Overrided");
	}*/
	public static void main(String args[]){
		B obj = new B();
		obj.run();
		obj.display();
	}
}