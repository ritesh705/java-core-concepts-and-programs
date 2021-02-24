package com.ritesh.java.concepts.contest;

import java.util.Arrays;
import java.util.Comparator;

public class BuildingBridges {

    public static void main(String[] args) {
        Pair[] A = new Pair[14];
        A[0] = new Pair(1,2);
        A[1] = new Pair(1,11);
        A[2] = new Pair(2,3);
        A[3] = new Pair(3,11);
        A[4] = new Pair(4,11);
        A[5] = new Pair(4,5);
        A[6] = new Pair(4,12);
        A[7] = new Pair(5,6);
        A[8] = new Pair(5,7);
        A[9] = new Pair(8,12);
        A[10] = new Pair(8,10);
        A[11] = new Pair(8,9);
        A[12] = new Pair(9,12);
        A[13] = new Pair(9,10);
        System.out.println(lis(A));
    }

    public static int lis(Pair[] A){
        Arrays.sort(A, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2)
            {
                return o1.x - o2.x;
            }
        });

        int n = A.length;
        int max = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(A[i].y > A[j].y){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max+2;
    }

    public static class Pair{
        int x, y;
        public Pair(int x_, int y_){
            x = x_;
            y = y_;
        }
    }

}
