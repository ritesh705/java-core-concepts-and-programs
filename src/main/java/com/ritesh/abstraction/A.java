package com.ritesh.abstraction;

class A extends B
{
	public void method()
	{
		System.out.println("Abstracton");
	}
	
	public static void main(String args[])
	{
		B obj = new A();
		obj.method();
	}
}