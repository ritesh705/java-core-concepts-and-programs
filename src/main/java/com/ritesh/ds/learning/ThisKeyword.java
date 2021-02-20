package com.ritesh.ds.learning;

public class ThisKeyword {
	int i;
	int j;
	String n;
	
	ThisKeyword(){
		System.out.println("Default Constructor Is Invoked");
	}
	
	ThisKeyword(int i,String n){
		this();
		this.i = i;
		this.n = n;
	}
	
	ThisKeyword(int i,String n,int j){
		this(i,n);
		this.j = j;
	}
	
	void display(){
		System.out.println(i+"\n"+n+"\n"+j);
	}
	public static void main(String args[]){
		ThisKeyword tk1 = new ThisKeyword(907120,"Ritesh",1);
		ThisKeyword tk2 = new ThisKeyword(907114,"Rahul");
		tk1.display();
		tk2.display();
	}

}