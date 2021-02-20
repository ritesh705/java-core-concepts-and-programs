package com.ritesh.ds.java8;

@FunctionalInterface
interface Java8Interface
{
    default void printLog(String log)
    {
        System.out.println(log);
    }

    static void printMessage(String message)
    {
        System.out.println(message);
    }

    public abstract void printSomething();
}

public class TestJava8Interface implements Java8Interface
{
    public static void main(String[] args)
    {
        TestJava8Interface testJava8Interface = new TestJava8Interface();
        testJava8Interface.printLog("test Log");
        Java8Interface.printMessage("Message");

        Java8Interface test1 = () -> System.out.println("Hello");

        Java8Interface test2 = new Java8Interface()
        {
            @Override
            public void printSomething()
            {
                System.out.println("Anonymous Class");
            }
        };

        test1.printSomething();
        test2.printSomething();
    }

    @Override
    public void printSomething() {
    }
}