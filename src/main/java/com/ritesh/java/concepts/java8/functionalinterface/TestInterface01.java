package com.ritesh.java.concepts.java8.functionalinterface;

public class TestInterface01
{
    public static void main(String[] args)
    {
        Java8Interface oldWay = new Java8Interface() {
            @Override
            public void printMessage(String str) {
                System.out.println("printMessage: "+str);
            }
        };
        oldWay.printMessage("oldWay");

        Java8Interface newWay = (s) -> System.out.println("printMessage: "+s);
        newWay.printMessage("newWay");

        Java8Interface.staticMethod("static method");
    }
}
