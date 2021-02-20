package com.ritesh.ds.learning;

class ThisArgumentCall {
	A a;
	ThisArgumentCall(A a){
		this.a = a;
	}
	void display(){
		System.out.println(a.data);
	}

}

class A{
	int data = 10;
	A(){
		ThisArgumentCall tac = new ThisArgumentCall(this);
		tac.display();
	}
	
	public static void main(String args[]){
		A a1 = new A();
	}
}