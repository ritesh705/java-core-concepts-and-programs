package com.ritesh.instnceof;

interface Printable{}

class A1 implements Printable{
	public void a(){
		System.out.println("CLass A1");
	}
}

class B2 implements Printable{
	public void b(){
		System.out.println("Class B2");
	}
}

class Call{
	void invoke(Printable p){
		if(p instanceof A){
			A1 a = (A1)p;
			a.a();
			System.out.println("Downcasted to Class A1");
		}
		if(p instanceof B){
			B2 b = (B2)p;
			b.b();
			System.out.println("Downcasted to Class B2");
		}
	}
}
class Test {
	public static void main(String args[]){
		Printable p = new B2();
		Call c = new Call();
		c.invoke(p);
	}
}