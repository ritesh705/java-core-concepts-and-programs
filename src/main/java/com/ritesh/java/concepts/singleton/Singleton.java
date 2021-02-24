package com.ritesh.java.concepts.singleton;

public class Singleton {
	
	public String name;
	
	public static Singleton instance = null;
	
	private Singleton(){
	}
	
	public static Singleton getInstance(){
		
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public void test(){
		System.out.println(name);
	}
}
