package com.ritesh.java.concepts.abstraction;

abstract class B
{
	public abstract void method();

	private void privateMethod()
	{
		System.out.println("Private Method.");
	}

	void defaultMethod(){
		System.out.println("Default Method.");
		privateMethod();
	}
}