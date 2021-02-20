package com.ritesh.ds.instnceof;

class B{
	void display(){
		System.out.println("Class B");
	}
}
class A extends B {
	void display(){
		System.out.println("Class A");
	}
	public static void main(String ars[]){
		A a =  new A();
		System.out.println(a instanceof A);
		a.display();
	}
}