package com.ritesh.java.concepts.java8.lambda;

import java.util.ArrayList;
import java.util.List;


public class Lambda
{
    public static void main(String... args)
    {
        forEachWithLambda();
    }

    private static void forEachWithLambda()
    {
        List<String> testLambda = new ArrayList<>();
        testLambda.add("One");
        testLambda.add("Two");
        testLambda.forEach(System.out::println);
        testLambda.stream().filter(p->p.equals("One")).forEach(System.out::println);
    }
}
