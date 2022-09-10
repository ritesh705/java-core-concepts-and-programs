package com.ritesh.java.concepts.java8.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ritesh.java.concepts.java8.util.Customer;
import com.ritesh.java.concepts.java8.util.Order;
import com.ritesh.java.concepts.java8.util.Product;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderStream
{
    private static List<Order> orders = null;

    public static void main(String[] args) throws IOException
    {
        // getResource, get the resource from src/main/resources
        File ordersJSON =
                new File(OrderStream.class.getClassLoader().getResource("orders.json").getFile());
        // Here I am using orderJSON File, but it supports String as well
        orders = Arrays.asList(new ObjectMapper().readValue(ordersJSON, Order[].class));

        getCheapestProduct();
        getRecentOrders();
        orderOnParticularDate();
        sumOfAllOrders();
        avgOfAllOrders();
        getStatistics();
        getDataMapByOrder();
        getDataMapByCustomer();
        getOrderProductSumDataMap();
        getDataMapByProductCategoryAndNames();
        getMostExpensiveProductByCategory();
        getDataMapByCustomer();
    }

    // Get The Cheapest Product Of Category Adult
    private static void getCheapestProduct()
    {
        Product product = orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> p.getCategory().equalsIgnoreCase("adult"))
                .min(Comparator.comparing(Product::getPrice))
                .get();
        System.out.println("Cheapest Product From Adult Category: ");
        System.out.println("01: "+product.getName()+" Price: "+product.getPrice());
    }

    // Get 3 Most Recent Orders
    private static void getRecentOrders()
    {
        List<Order> threeMostRecentOrders = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Three Most Recent Orders:");
        threeMostRecentOrders.forEach(o -> System.out.println("Order Date: "+o.getOrderDate()));
    }

    // Products Ordered On Particular Date
    private static void orderOnParticularDate()
    {
        System.out.println("Orders On Particular Date: ");
        List<Product> productsOrderOnParticularDate = orders.stream()
                .filter(o-> o.getOrderDate().isEqual(LocalDate.parse("2022-01-01")))
                .peek(o -> System.out.println("Order Id: "+o.getId())) // To Print in between
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Products On Particular Date: ");
        productsOrderOnParticularDate.forEach(p -> System.out.println("Product: "+p.getName()));
    }

    // Sum Of All Orders In A Particular Date Range
    private static void sumOfAllOrders()
    {
        Double sum = orders.stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2022, 01, 01))>=0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2022, 01, 31))<=0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .sum();
        System.out.println("Sum: "+sum);
    }

    // Average Of All Orders In A Particular Date Range
    private static void avgOfAllOrders()
    {
        Double average = orders.stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2022, 01, 01))>=0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2022, 01, 31))<=0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .average()
                .getAsDouble();
        System.out.println("Average: "+average);
    }

    // Product Statistics
    private static void getStatistics(){
        DoubleSummaryStatistics statistics = orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> p.getCategory().equalsIgnoreCase("baby"))
                .mapToDouble(p -> p.getPrice())
                .summaryStatistics();
        System.out.println("Statistics");
        System.out.println("Max: "+statistics.getMax()+" | Average: "+statistics.getAverage());
    }

    // Data Map | OrderId, Product Count
    private static void getDataMapByOrder()
    {
        Map<String, Integer> dataMap = orders.stream()
                .collect(Collectors.toMap(o -> o.getId(), o -> o.getProducts().size()));
        System.out.println("Data Map By Order:");
        dataMap.entrySet().forEach(System.out::println);
    }

    // Data Map | Customer Id, Order
    private static void getDataMapByCustomer()
    {
        // Grouping By Customer Id
        Map<String, List<Order>> dataMap01 =
        orders.stream()
               .collect(Collectors.groupingBy(o -> o.getCustomer().getId()));
        System.out.println("Data Map By Customer: ");
        dataMap01.entrySet().forEach(System.out::println);

        // Grouping By Customer
        Map<Customer, List<Order>> dataMap02 =
                orders.stream()
                        .collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println("Data Map By Customer: ");
        dataMap02.entrySet().forEach(System.out::println);
    }

    // Data Map | Order, Product Total Sum
    private static void getOrderProductSumDataMap()
    {
        /* Function.identity() is used to tell Collectors.toMap() to use the data element as the key.
        Also we can use o->o in place of Function.identity() */
        Map<Order, Double> dataMap = orders.stream()
                .collect(Collectors.toMap(Function.identity(), o->o.getProducts().stream()
                                                                    .mapToDouble(p-> p.getPrice())
                                                                    .sum()));
        System.out.println("Data Map Order, Product Total Sum: ");
        dataMap.entrySet().forEach(System.out::println);

    }

    // Data Map | Product Category, Product Names
    private static void getDataMapByProductCategoryAndNames()
    {
        Map<String, List<String>> dataMap = orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.groupingBy(p->p.getCategory(),
                            Collectors.mapping(p->p.getName(), Collectors.toList())));
        System.out.println("Data Map By Product Category And Product Names: ");
        dataMap.entrySet().forEach(System.out::println);
    }

    // Data Map | Most Expensive Product By Category
    private static void getMostExpensiveProductByCategory()
    {
        Map<String, Optional<Product>> dataMap = orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getCategory,
                            Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        System.out.println("Data Map For Most Expensive Product By Category: ");
        dataMap.entrySet().forEach(System.out::println);
    }
}
