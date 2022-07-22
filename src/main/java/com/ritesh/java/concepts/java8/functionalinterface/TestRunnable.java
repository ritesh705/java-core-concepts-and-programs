package com.ritesh.java.concepts.java8.functionalinterface;

public class TestRunnable
{
    public static void main(String[] args)
    {
        /* Runnable is Java functional interface*/

        // Using anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }).start();

        // Using Lambda
        new Thread(()->System.out.println("Runnable")).start();
    }
}
