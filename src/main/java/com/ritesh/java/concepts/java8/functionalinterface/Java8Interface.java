package com.ritesh.java.concepts.java8.functionalinterface;

@FunctionalInterface
public interface Java8Interface
{
    default void defaultMethod(String str)
    {
        System.out.println("print01: "+str);
    }

    static void staticMethod(String str)
    {
        System.out.println("print02: "+str);
    }

    void printMessage(String str);
}
