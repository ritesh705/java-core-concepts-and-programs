package com.ritesh.java.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test
{
    public static void main(String[] args)
    {
       /* String ipString = "test test test01 data hyd hyd bgl bangalore ranchi" +
                " puri odisha odisha ram ram ram krishna shiva";
        countAndPrint(ipString);*/
        System.out.println(solution("50552"));
    }

    private static void countAndPrint(String input)
    {
        // No Input Validation as of now
        String[] strArray = input.split(" ");
        Map<String, Integer> ipMap = new HashMap<>();
        for(int i=0; i<strArray.length; i++)
        {
            if(ipMap.get(strArray[i]) != null) // Blank Check
            {
                int count = ipMap.get(strArray[i])+1;
                ipMap.put(strArray[i], count);
            }
            else
            {
                ipMap.put(strArray[i], 1);
            }
        }

        for(String str : ipMap.keySet())
        {
            System.out.println("Word: "+str+" Frequency: "+ipMap.get(str));
        }
    }
    
    public static int solution(String str)
    {
        // write your code in Java SE 8
        int maxVal = -1;
        int inputLength = 0;
        if(str != null)
        {
            inputLength = str.length();
        }
        for(int i=0; i<inputLength-1; i++)
        {
            String twoDigitStr = str.substring(i, i+2);
            Integer currentVal = Integer.parseInt(twoDigitStr);
            if(currentVal > maxVal)
            {
                maxVal = currentVal;
            }
        }
        return maxVal;
    }

}
