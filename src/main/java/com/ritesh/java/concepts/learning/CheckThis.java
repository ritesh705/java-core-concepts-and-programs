package com.ritesh.java.concepts.learning;

public class CheckThis
{
	void display()
	{
		System.out.println(this);
	}
	public static void main(String args[])
	{
		CheckThis ct = new CheckThis();
		ct.display();
		System.out.println(ct);
	}
}