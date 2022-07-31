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

        // Method 02 | Using collect
        Map<Object, Long> countMap01 =
                inputs.stream().collect(groupingBy(ip -> ip, counting()));

        countMap01.entrySet().forEach((kv) -> System.out.println(kv));
    }

    private static void processEmployeeData()
    {
        Employee e1 = new Employee("Krishna", "SE", 150000.00);
        Employee e2 = new Employee("Ram", "SSE", 250000.00);
        Employee e3 = new Employee("Shiva", "SSE", 200000.00);
        Employee e4 = new Employee("Krishna", "SSE", 200000.00);
        Employee e5 = new Employee("Ram", "SSE", 249999.00);

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5);

        // Using Collect
        final double[] totalSalary = {0};
        List<Double> salaryList = employees.stream()
                .filter(e -> e.getDepartment().equals("SE"))
                .map(e -> totalSalary[0] = totalSalary[0]+e.getSalary())
                .collect(toList());
        System.out.println(salaryList.get(salaryList.size()-1));

        // Using Reduce | Recommended
        Optional<Double> sumOfSalary = employees.stream()
                .filter(e -> e.getDepartment().equals("SE"))
                .map(e01 -> e01.getSalary())
                .reduce((s1, s2) -> s1+s2);
        sumOfSalary.ifPresent(System.out::println);

        // Sorting
        employees.sort(Comparator.comparing(Employee :: getName).thenComparing(Employee :: getSalary));

        employees.forEach(e-> System.out.println(e.getName()+" "+e.getSalary()));
    }

}
