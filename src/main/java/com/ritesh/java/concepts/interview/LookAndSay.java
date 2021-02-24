package com.ritesh.java.concepts.interview;

public class LookAndSay {

	public String genSeq(String number){
		StringBuilder result= new StringBuilder();
	 
		char repeat= number.charAt(0);
		number = number.substring(1)+" ";
		int times = 1;
	 
		for(char actual : number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat= actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args){
		LookAndSay ls = new LookAndSay();
		String result = ls.genSeq("21");
		System.out.println(result);
	}
}
