package com.ritesh.java.concepts.initializer;

public class B extends A {
	
	B(){
		System.out.println("Sub Class Constructor");
	}
	
	{
		System.out.println("Object Initializer Block");
	}
	
	B(int i) {
		System.out.println("Sub Class Constructor With Parameter");
	}
	
	public static void main(String[] args) {
		B b_01 = new B();
		B b_02 = new B(01);
	}

}
