package com.ritesh.java.concepts.thiskeyword;

public class Test02 {

	Test01 test01;
	Test02(Test01 test01) {
		this.test01 = test01;
	}
	
	public void display() {
		System.out.println(test01.id);
	}
	
	Test02 getTest02() {
		return this;
	}
}
