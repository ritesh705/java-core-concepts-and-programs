package com.ritesh.java.concepts.ifelse;

public class Test01 {

	public void m()
	{
		boolean testValue01 = false;
		boolean testValue02 = false;
		try
		{
			//testValue01 = true;
			testValue02 = true;
			if(testValue01){System.out.println(testValue01);}
			else if(testValue02){System.out.println(testValue02);}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public static void main(String[] args){
		Test01 tes01_01 = new Test01();
		tes01_01.m();
	}
}
