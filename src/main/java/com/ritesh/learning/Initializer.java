package com.ritesh.learning;

class SuperClass {
	SuperClass(){
		System.out.println("Super Class Constructor");
	}
}

class Initializer extends SuperClass {
	Initializer(){
		super();
		System.out.println("Default Constructor");
	}
	Initializer(int a){
		super();
		System.out.println("Parametrized Constructor");
	}
	{
		System.out.println("Instance Initializer");
	}
	public static void main(String args[]){
		Initializer i1 = new Initializer();
		Initializer i2 = new Initializer(2);
	}
}