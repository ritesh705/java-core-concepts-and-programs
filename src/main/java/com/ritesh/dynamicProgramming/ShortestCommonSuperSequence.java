/**
 * 
 */
package com.ritesh.dynamicProgramming;


/**
 * @author Ritesh
 *
 */
public class ShortestCommonSuperSequence {

	private String getSCSS(String s1, String s2){
		
		String lcss = getLCSS(s1, s2);
		int l1 = s1.length();
		int l2 = s2.length();
		int lSCSS = l1 + l2 - lcss.length();
		System.out.println(lcss.length());
		int i = 0;
		int j = 0;
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < lSCSS; k++){
			if(i < l1 && j < l2 && s1.charAt(i) == s2.charAt(j)){
				sb.append(s1.charAt(i));
				i++;
				j++;
				}
			else{
				if(i < l1){
					sb.append(s1.charAt(i));
					i++;
					}
				if(j < l2){
					sb.append(s2.charAt(j));
					j++;
					}
				}
		}
		return sb.toString();
		}
	
	private String getLCSS(String s1, String s2){
		
		int m = s1.length();
		int n = s2.length();
		int L[][] = new int[m+1][n+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 || j == 0){
					L[i][j] = 0;
					}
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					L[i][j] = L[i-1][j-1] + 1;
					sb.append(s1.charAt(i-1));
					}
				else{
					L[i][j] = max(L[i-1][j], L[i][j-1]);
					}
				}
			}
		return sb.toString();
	}

	private int max(int i, int j) {

		return(i > j ? i : j);
		}
	
	public static void main(String args[]){
		
		ShortestCommonSuperSequence shortestCommonSuperSequence = new ShortestCommonSuperSequence();
		String s1 = "abcde";
		String s2 = "afhcdg";
		String scss = shortestCommonSuperSequence.getSCSS(s1, s2);
		System.out.println(scss);
	}
}
