package com.ritesh.java.concepts.contest;



public class Palindrome {
	
	public static int findLongestPalindromeLength(String[] input1){
		
		String str = "";
		for(String name : input1)
		{
			if(!(name == null))
			{
				name = name.trim();
				if(!name.equals(""))
				{
					Character firstCharacter = name.charAt(0);
					str = str + firstCharacter;
				}
			}
		}
		System.out.println(str+" "+findLongestPalindrome(str).length());
		return findLongestPalindrome(str).length();
	}

	public static String findLongestPalindrome(String s) {
		
	        if (s.length() == 0)
	            return "";
	        if (s.length() == 1 || (s.length() == 2 && s.charAt(0) != s.charAt(1)))
	            return s.charAt(0) + "";
	        if (s.length() == 2)
	            return s;

	        char[] arr = s.toCharArray();

	        boolean match = false;
	        int i = 0;
	        for (i = arr.length - 1; i > 0; i--) {
	            if (arr[i] == arr[0]) {
	                match = true;
	                break;
	            }
	        }

	        int max = 0;
	        String maxPalin = "";
	        for (int k = 1; k < i; k++) {
	            String p = findLongestPalindrome(s.substring(k, i));
	            if (p.length() > max) {
	                max = p.length();
	                maxPalin = p;
	            }
	        }

	        if (match)
	            return arr[0] + maxPalin + arr[0];
	        return maxPalin;
    }

	public static void main(String[] args){
	
		String[] names = {null, "    ","Binay","Brijesh","Ananth","Baidhyanath","Chhota", "BrijMohan", "Anil", "Bicky"};
		findLongestPalindromeLength(names);
	}
}
