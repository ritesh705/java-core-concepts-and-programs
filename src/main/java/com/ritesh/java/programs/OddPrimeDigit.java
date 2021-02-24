package com.ritesh.java.programs;

import static java.lang.Math.sqrt;

public class OddPrimeDigit
{
    public static void main(String[] args)
    {
        int l = 1;
        int r = 10;
        int count = oddDigitPrime(1, 10, 1);
        System.out.println(count);
    }

    public static int oddDigitPrime(int l, int r, int t)
    {
        int oddDigitPrimeCount = 0;
        for(int i = l; i <= r; i++)
        {
            if(isPrime(i) && isOdd(i))
            {
                if(t == 1)
                {
                    if(isCategory01(i))
                    {
                        oddDigitPrimeCount++;
                    }
                }
                else if(isCategory02(i))
                {
                    oddDigitPrimeCount++;
                }
            }
        }
        return oddDigitPrimeCount;
    }

    private static boolean isOdd(int i)
    {
        boolean isOdd = true;
        if(i%2 == 0)
        {
            isOdd = false;
        }
        return isOdd;
    }

    private static boolean isPrime(int num)
    {
        boolean isPrime = true;
        if(num == 2)
        {
            isPrime = true;
        }
        else if(num == 1 || num%2==0)
        {
            isPrime = false;
        }
        else
        {
            for(int i = 3; i<=sqrt(num); i+=2)
            {
                if(num%i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }

    private static boolean isCategory01(int num)
    {
        boolean result = false;
        while(num>0)
        {
            result =  false;
            if(num%10 <= 5)
            {
                result = true;
            }
            num = num/10;
        }
        return result;
    }

    private static boolean isCategory02(int num)
    {
        boolean result = false;
        while(num>0)
        {
            result =  false;
            if(num%10 > 5)
            {
                result = true;
            }
            num = num/10;
        }
        return result;
    }
}
