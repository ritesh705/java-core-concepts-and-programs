package com.ritesh.java.concepts.binding;

class A {
	void display(){
		System.out.println("Class A");
	}
	public static void main(String args[]){
		A a = new A();
		a.display();
	}
}