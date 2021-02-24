package com.ritesh.java.concepts.thiskeyword;

public class Test01 {

	int id;
	String name;
	String city;
	
	Test01(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	Test01(int id, String name, String city){
		this(id, name);
		this.city = city;
		Test02 test02 = new Test02(this);
		test02.display();
	}
	
	public void passThis(Test01 test01){
		System.out.println("this keyword is passed as an argument in method");
	}
	
	public void display(){
		passThis(this);
		System.out.println(id+" "+name+" "+city);
	}
	
	public static void main(String[] args){
		Test01 test01_1 = new Test01(1, "Abc");
		Test01 test01_2 = new Test01(2, "Xyz", "Hyderabad");
		test01_1.display();
		test01_2.display();
		new Test02(test01_1).getTest02().display();
	}
}
