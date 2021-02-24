package com.ritesh.java.concepts.polymorphism;

class A {
	int i = 10;
	void display(){
		System.out.println("Super Class");
	}
}

class B extends A {
	int i = 20;
	void display(){
		super.display();
		System.out.println("Sub Class");
	} 
	public static void main(String args[]){
		A a = new B();
		a.display();
		System.out.println(a.i);
	}
}
