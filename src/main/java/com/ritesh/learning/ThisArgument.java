package com.ritesh.learning;

class ThisArgument {
	void m(ThisArgument ta){
		System.out.println("Method Invoked");
	}
	void n(){
		m(this);
	}
	public static void main(String args[]){
		ThisArgument ta1 = new ThisArgument();
		ta1.n();
	}
}
