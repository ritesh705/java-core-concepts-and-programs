package com.ritesh.inheritance;


public class TestProtected implements Cloneable {

	public static void main(String args[]){
		
		SuperClass sc = new SuperClass();
		sc.id = 1;
		
		ThreadGroup tg = new ThreadGroup("threadGroup01");
		tg.setMaxPriority(8);
		System.out.println(tg.getMaxPriority());
		}
	}