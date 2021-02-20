package com.ritesh.ds.learning;

class StaticMethod {
	int x;
	
	static int calculation(int x){
		return(x*x*x);
	}
	
	public static void main(String args[]){
		int result;
		result = StaticMethod.calculation(5);
		System.out.println("Cube = "+StaticMethod.calculation(2));
		System.out.println("Cube = "+result);
	}
}
