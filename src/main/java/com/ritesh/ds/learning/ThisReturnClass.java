package com.ritesh.ds.learning;

class ThisReturnClass {
	ThisReturnClass m(){
		return this;
	}
	void display(){
		System.out.println("this Keyword returns class");
	}
}

class Test{
	public static void main(String args[]){
		ThisReturnClass trc = new ThisReturnClass();
		trc.m().display();
	}
}