package com.ritesh.java.concepts.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStream
{
    public static void main(String[] args)
    {
        //simpleStreamProcessing();
        parallelStreamProcessing();
    }

    private static void simpleStreamProcessing()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum01 = numbers.stream().reduce(0, (n1, n2)->n1+n2);
        int sum02 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("simpleStreamProcessing: "+sum01);
        System.out.println("simpleStreamProcessing: "+sum02);
    }

    private static void parallelStreamProcessing()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum01 = numbers.parallelStream().reduce(0, Integer::sum);
        numbers.parallelStream().forEach(num ->
                System.out.println(num+" Thread: "+Thread.currentThread().getName()));
        System.out.println("parallelStreamProcessing: "+sum01);
    }
}
