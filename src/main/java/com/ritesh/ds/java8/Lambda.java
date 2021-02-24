package com.ritesh.ds.java8;

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
        List<String> testLambda = new ArrayList();
        testLambda.add("One");
        testLambda.add("Two");
        testLambda.forEach(p->printResult(p));
        testLambda.stream().filter(p->p.equals("One")).forEach(q -> System.out.println(q));
    }

    private static void printResult(String str)
    {
        System.out.println(str);
    }
    
}