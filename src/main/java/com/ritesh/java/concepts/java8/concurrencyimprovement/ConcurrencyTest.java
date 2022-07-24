package com.ritesh.java.concepts.java8.concurrencyimprovement;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class ConcurrencyTest
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        runOldConcurrencyExample();
        runJava5ConcurrencyExample();
        runJava8ConcurrencyExample01(); // CompletableFuture And Runnable
        runJava8ConcurrencyExample02(); // CompletableFuture And Supplier
        runJava8ConcurrencyExample03(); // Manually Completing Thread
        runJava8ConcurrencyExample04(); // thenAccept | Callback method supported by Completable Future
        runJava8ConcurrencyExample05(); // thenApply | Callback method supported by Completable Future
        runJava8ConcurrencyExample06(); // Chaining Callbacks
        runJava8ConcurrencyExample07(); // Combining Results from multiple Completable Future
        runJava8ConcurrencyExample08(); // Exception Handling In Completable Future
    }

    private static void runOldConcurrencyExample()
    {
        /*
         In case of ‘Runnable’
         The main thread has no way of knowing that the run method has completed,
         meaning it can’t be used to return a result to the main method.
        * */
        Runnable r1 = () -> System.out.println("r1");
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(()-> System.out.println("r2"), "t2");
        t1.start();
        t2.start();
    }

    private static void runJava5ConcurrencyExample() throws ExecutionException, InterruptedException
    {
        /*
        Although the ‘Future’ interface enables you to return a result from a Thread,
        it has several disadvantages including:

        The 'get' method in the 'Future' interface is blocking,
        so if the result of computation is complete, it returns immediately.
        Otherwise, it'll wait till the computation is completed.
        If you want to perform some actions on the result of the computation,
        you'll need to wait till the result is available.

        The 'Future' interface does not support any exception handling mechanism.
        To solve all these issues, the ‘CompletableFuture’ class was introduced by Java 8.
        * */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () ->
        {
            System.out.println("Inside callable interface");
            Thread.sleep(10000);
            return "result from callable";
        };

        System.out.println("Before Starting Thread.");
        Future<String> future = executorService.submit(callable);
        System.out.println("Doing something else");
        System.out.println("Before Future.get()");
        String result = future.get();
        System.out.println("After Future.get()");
        System.out.println(result);

        executorService.shutdown();
    }

    private static void runJava8ConcurrencyExample01()
    {
        System.out.println("Inside runJava8ConcurrencyExample01");
        Runnable runnable = () -> System.out.println("Inside Runnable");
        System.out.println("Main Started...");
        CompletableFuture<Void> result = CompletableFuture.runAsync(runnable);
        System.out.println("Do other parallel task.");
        System.out.println("Task Completed");
    }

    private static void runJava8ConcurrencyExample02() throws ExecutionException, InterruptedException
    {
        System.out.println("Inside runJava8ConcurrencyExample02");
        Supplier supplier = () -> "return from Supplier";
        System.out.println("Main Started...");
        CompletableFuture<String> result = CompletableFuture.supplyAsync(supplier);
        System.out.println("Do other parallel task.");
        System.out.println("Getting Result From Thread");
        System.out.println("Result From Thread: "+result.get());
        System.out.println("Task Completed.");
    }

    private static void runJava8ConcurrencyExample03() throws ExecutionException, InterruptedException
    {
        System.out.println("Inside runJava8ConcurrencyExample03");
        Supplier supplier = () ->
        {
            System.out.println("Inside Supplier");
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return "return from Supplier";
        };
        System.out.println("Main Started...");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("Do other parallel task.");
        System.out.println("Getting for result from Thread...");
        int count = 0;
        while(!completableFuture.isDone())
        {
            System.out.println("Waiting for result from Thread... "+count);
            count++;
            if(count == 6)
            {
                break;
            }
        }
        completableFuture.complete("Manually Completed Thread.");
        System.out.println("CompletedFuture Result: "+completableFuture.get());
        System.out.println("Task Completed.");
    }

    private static void runJava8ConcurrencyExample04() throws ExecutionException, InterruptedException
    {
        System.out.println("Inside runJava8ConcurrencyExample04");
        Supplier<String> supplier = () ->
        {
            System.out.println("Inside Supplier");
            return "return from Supplier";
        };
        System.out.println("Main Start...");
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(supplier)
                .thenAccept(s -> System.out.println("Then Accept Example: "+s.toUpperCase()));
        System.out.println("Do other parallel task.");
        System.out.println("Task Completed.");
    }

    private static void runJava8ConcurrencyExample05() throws ExecutionException, InterruptedException
    {
        System.out.println("Inside runJava8ConcurrencyExample05");
        Supplier<String> supplier = () ->{
            String result = "return from Supplier";
            return result;
        };
        System.out.println("Main Start...");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier)
                .thenApply(str -> str.toUpperCase());
        System.out.println("Other Parallel Task Started...");
        System.out.println("Getting Result From Thread...");
        String result = completableFuture.get();
        System.out.println("Then Apply Example: "+result);
        System.out.println("Main Task Completed.");
    }

    private static void runJava8ConcurrencyExample06() throws ExecutionException, InterruptedException
    {
        System.out.println("Inside runJava8ConcurrencyExample06");
        Supplier<String> supplier = () ->{
            String result = "return from Supplier";
            return result;
        };
        System.out.println("Main Start...");
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(supplier)
                .thenApply(str -> str.toUpperCase())
                .thenAccept(str ->
                        System.out.println("Then Apply Then Accept (Chaining Callbacks) " +
                                "Example: "+str.toUpperCase()));
        System.out.println("Other Parallel Task Started...");
        System.out.println("Main Task Completed.");
    }

    private static void runJava8ConcurrencyExample07() throws ExecutionException, InterruptedException
    {
        System.out.println("Inside runJava8ConcurrencyExample07");
        CompletableFuture<Double> lengthOfRectangle = CompletableFuture
                .supplyAsync(()-> 6.0);
        CompletableFuture<Double> breadthOfRectangle = CompletableFuture
                .supplyAsync(()-> 2.0);
        System.out.println("Main Start...");
        CompletableFuture<Double> area = lengthOfRectangle
                .thenCombine(breadthOfRectangle, (length, breadth) -> {
                    System.out.println("Length: "+length);
                    System.out.println("Breadth: "+breadth);
                    return length*breadth;
                });
        System.out.println("Other Parallel Task Started...");
        System.out.println("Area: "+area.get());
        System.out.println("Main Task Completed.");
    }

    private static void runJava8ConcurrencyExample08() throws ExecutionException, InterruptedException {
        Supplier<String> supplier = () ->
        {
            String str = null;
            if(str != null)
            {
                return "Str is not null.";
            }
            else
            {
                throw new RuntimeException("Str is null.");
            }
        };

        CompletableFuture completableFuture = CompletableFuture.supplyAsync(supplier)
                .exceptionally(ex -> {
                    System.out.println("Exception: "+ex.getMessage());
                    return "Please Check Exception Occurred.";
                });
        System.out.println(completableFuture.get());
    }
}
