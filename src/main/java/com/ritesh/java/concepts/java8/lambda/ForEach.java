package com.ritesh.java.concepts.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class ForEach
{
    public static void main(String[] args)
    {
        List list = Arrays.asList("test01", "test02", "test03", "test04", "test05");
        // Java 8 For Each Loop
        list.forEach(str -> System.out.println(str));
    }
}
