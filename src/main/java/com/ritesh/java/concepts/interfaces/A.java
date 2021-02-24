package com.ritesh.java.concepts.interfaces;

interface Printable{
	int i = 0;
	void print();
	}

interface Showable {
	
	void show();
	void print();
	}

/**
 * @author Ritesh
 *
 */
class A implements Printable, Showable {
	public void print(){
		System.out.println("Hi");
		}
	public void show(){
		System.out.println("Hello");
		}
	public static void main(String args[]){
		Showable ref;
		A obj = new A();
		ref = obj;
		ref.show();
		System.out.println(i);
		}
	}