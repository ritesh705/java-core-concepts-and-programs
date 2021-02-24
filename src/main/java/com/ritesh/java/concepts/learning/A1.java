package com.ritesh.java.concepts.learning;

class Super {
	Super(){
		System.out.println("Super Class");
	}
	void message(){
		System.out.println("Super Class Method Invoked By Compiler");
	}
}

class A1 extends Super {
	A1(){
		super(); // super() is added automatically by compiler also
		System.out.println("Sub Class");
	}
	void message(){
		System.out.println("Sub Class Method Invoked By Compiler");
	}
	void display(){
		message();
		super.message();
	}
	public static void main(String args[]){
		A1 obj = new A1();
		obj.display();
	}
}