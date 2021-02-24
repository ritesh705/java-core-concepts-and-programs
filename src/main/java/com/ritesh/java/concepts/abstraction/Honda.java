package com.ritesh.java.concepts.abstraction;

abstract class Bike{
	int i = 10;
	
	Bike(){
		System.out.println("Constructor Invoked");
	}
	abstract void run();
	void operation(){
		System.out.println("Gear Changed");
	}
	void display(){
		System.out.println(i);
	}
}

class Honda extends Bike {
	void run(){
		System.out.println("Bike Is Running Now");
	}
	public static void main(String args[]){
		Bike obj = new Honda();
		obj.run();
		obj.operation();
		obj.display();
	}
}