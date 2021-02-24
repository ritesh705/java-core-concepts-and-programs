package com.ritesh.java.concepts.reverse;

public class Reverse {
	
	private int reverseNumber(int ip){
		
		int reverse = 0;
		while(ip != 0){
			reverse = reverse * 10;
			reverse = reverse + (ip % 10);
			ip = ip / 10;
		}
		return reverse;
	}
	
	private String reverseString(String ip){
		
		int l = ip.length();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		for(i = l-1; i >= 0; i--){
			sb.append(ip.charAt(i));
		}
		return sb.toString();
	}
	
	private String reverseStringUsingStringBuffer(String ip){
		
		if(ip != null){
			StringBuffer sb = new StringBuffer(ip);
			return sb.reverse().toString();
		}
		return null;
	}
	
	private String reverseSentence(String ip){
		
		if(ip.length() > 0){
			String[] givenSentence = ip.split(" ", 0);
			int lengthOfArray = givenSentence.length;
			StringBuilder sb = new StringBuilder();
			String[] reversedSentence = new String[lengthOfArray];
			for(int i = lengthOfArray-1; i >= 0; i--){
				int j = 0;
				reversedSentence[j] = new String(givenSentence[i]);
				sb.append(reversedSentence[j]);
				sb.append(" ");
				j++;
			}
			String opString = sb.toString();
			return opString;
		}
		return null;
	}
	
	
	public static void main(String args[]){
		
		Reverse reverse = new Reverse();
		int opInt = reverse.reverseNumber(1201);
		//System.out.println(opInt);
		String opString = reverse.reverseString("Reverse String");
		System.out.println(opString);
		//String opStringFromStringBuffer = reverse.reverseStringUsingStringBuffer("Reverse String Using Method Of StringBuffer");
		//System.out.println(opStringFromStringBuffer);
		//String opSentence = reverse.reverseSentence("Method For Reversing Given Sentence");
		//System.out.println(opSentence);
	}
}
