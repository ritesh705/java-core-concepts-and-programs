package com.ritesh.inheritance;

public class SubClass extends SuperClass {

	public void assignId(){
		id = 02;
		}
	
	public void display(){
		System.out.println("SubClass");
		}
	
	public void displaySubClass(){
		System.out.println("DisplaySubClass");
		}
		
	public static void main(String[] args){
		SuperClass sc = new SubClass();
		sc.display();
	}
}
