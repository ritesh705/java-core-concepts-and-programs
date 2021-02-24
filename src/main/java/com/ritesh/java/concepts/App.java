package com.ritesh.java.concepts;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.solution(18, 2);
    }

    public int solution(int N, int K)
    {
        List<Integer> list = new ArrayList();
        int sum = 1;
        int kCount = 0;

        for(int j = 0 ; j<K; j++)
        {
            for(int i=0; i<N-1; i++)
            {
                sum = sum+1;
                if(kCount<K)
                {
                    sum = getAllInSumForI(sum-1, i);
                    kCount++;
                }
                if(sum == N)
                {
                    list.add(i);
                    break;
                }
                if(sum > N)
                {
                    break;
                }
            }
        }

        int minimum = getMinimum(list);
        return minimum;
    }

    private int getAllInSumForI(int sum, int i1)
    {
        sum=sum+sum;
        return sum;
    }

    private int getMinimum(List<Integer> list)
    {
        int min = 0;
        for(Integer val : list)
        {
            if(min>val)
            {
                min=val;
            }
        }
        return min;
    }
}
