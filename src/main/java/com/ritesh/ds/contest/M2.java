package com.ritesh.ds.contest;


public class M2 {
	
	final static String deliminator = ",";
	public static String StartM2(String input){
		
		String output = null;
		int flag = 0;
		String selectedSeq = input;
		flag = 1;
		output = StartM1(selectedSeq);
		String[] opSequence = output.split(deliminator);
		while(opSequence.length != 1)
		{
			if(flag != 0)
			{
				selectedSeq = output;
				output = StartM1(selectedSeq);
			}
			opSequence = output.split(deliminator);
		}
		flag = 2;
		return opSequence[0];
	}
	
	public static String StartM1(String input){
			
			String output = "";
			String[] sequence = null;
			if(!(input == null))
			{
				sequence = input.split(deliminator);
				if(sequence.length > 1)
				{
					int i = 0;
					for(String seqDigitStr : sequence)
					{
						if(isNumeric(seqDigitStr) && isNumeric(sequence[i+1]))
						{
							int seqDigit = Integer.parseInt(seqDigitStr);
							int seqDigitNext = Integer.parseInt(sequence[i+1]);
							output = output + (seqDigitNext - seqDigit)+""+",";
							if(i == sequence.length-2)
							{
								break;
							}
							i++;
						}
					}
				}
			}
			return output;
		}
	
	public static boolean isNumeric(String string) {
	      return string.matches("^[-+]?\\d+(\\.\\d+)?$");
	  }
	
	public static void main(String[] args){
		
		String op = StartM2("1,117,1,5,9,2,3,5,6,10");
		System.out.println(op);
	}
}
