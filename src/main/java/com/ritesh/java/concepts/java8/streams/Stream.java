package com.ritesh.java.concepts.java8.streams;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Stream
{
    public static void main(String[] args)
    {
        createMap();
        processEmployeeData();
    }

    public static void createMap()
    {
        List<String> inputs = Arrays.asList("AB", "BC", "AB", "CD", "DE");

        // Method 01
        Map<String, Integer > countMap = new HashMap<>();
        if(inputs != null && inputs.size() > 0)
        {
            inputs.forEach(ip->
            {
                if(countMap.get(ip) != null)
                {
                    countMap.put(ip, countMap.get(ip)+1);
                }
                else
                {
                    countMap.put(ip, 1);
                }
            });
        }

        // Method 2
        Map<Object, Long> countMap01 =
                inputs.stream().collect(groupingBy(ip -> ip, counting()));
    }

    private static void processEmployeeData()
    {
        Employee e1 = new Employee("Krishna", "SE", 150000.00);
        Employee e2 = new Employee("Ram", "SE", 150000.00);
        Employee e3 = new Employee("Shiva", "SSE", 200000.00);

        List<Employee> employees = Arrays.asList(e1, e2, e3);

        // Using Collect
        final double[] totalSalary = {0};
        List<Double> salaryList = employees.stream()
                .filter(e -> e.getDepartment().equals("SE"))
                .map(e -> totalSalary[0] = totalSalary[0]+e.getSalary())
                .collect(toList());
        System.out.println(salaryList.get(salaryList.size()-1));

        // Using Reduce
        Optional<Double> salaries = employees.stream()
                .filter(e -> e.getDepartment().equals("SE"))
                .map(e01 -> e01.getSalary())
                .reduce((s1, s2) -> s1+s2);
        salaries.ifPresent(System.out::println);
    }

}
