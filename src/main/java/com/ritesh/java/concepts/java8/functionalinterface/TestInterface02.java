package com.ritesh.java.concepts.java8.functionalinterface;

public class TestInterface02 implements Java8Interface
{
    @Override
    public void printMessage(String str) {
    }

    public static void main(String[] args)
    {
        TestInterface02 testInterface02 = new TestInterface02();
        testInterface02.defaultMethod("default method");

        Java8Interface.staticMethod("static method");
    }
}
