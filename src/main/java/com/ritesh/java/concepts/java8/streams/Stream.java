package com.ritesh.java.concepts.java8.streams;

import com.ritesh.java.concepts.java8.util.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Stream
{
    public static void main(String[] args)
    {
        groupStringListUsingStream();
        List<Employee> employees = getEmployees();
        getTotalSalaryOfEmployeesBelongingToSEDepartment(employees);
        groupEmployeesByDepartment(employees);
        getSortedEmployeeList(employees);
        sortIntegerByFrequency();
        countEmployeeByDepartment();
    }

    private static List<Employee> getEmployees()
    {
        List<Employee> employees = null;
        Employee e1 = new Employee("Krishna", "SE", 150000.00);
        Employee e2 = new Employee("Ram", "SSE", 250000.00);
        Employee e3 = new Employee("Shiva", "SSE", 200000.00);
        Employee e4 = new Employee("Krishna", "SSE", 200000.00);
        Employee e5 = new Employee("Ram", "SSE", 249999.00);
        employees = Arrays.asList(e1, e2, e3, e4, e5);
        return employees;
    }

    // Group And Count
    public static void groupStringListUsingStream()
    {
        List<String> inputs = Arrays.asList("AB", "BC", "AB", "CD", "DE");
        groupListOfStringUsingStream(inputs);
    }

    private static void groupListOfStringUsingStream(List<String> inputs)
    {
        Map<Object, Long> countMap =
                inputs.stream().collect(Collectors.groupingBy(ip -> ip, Collectors.counting()));
        countMap.entrySet().forEach((kv) -> System.out.println(kv));
    }

    // Sorting
    private static void getSortedEmployeeList(List<Employee> employees)
    {
        employees.sort(Comparator.comparing(Employee :: getName).thenComparing(Employee :: getSalary));
        employees.forEach(e-> System.out.println(e.getName()+" "+e.getSalary()));
    }

    // Group Employee By Department
    private static void groupEmployeesByDepartment(List<Employee> employees)
    {
        Map<Object, Long> map =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        map.entrySet().stream().forEach(System.out::println);
    }

    // Total Salary Of Employee, Department = SE | Using Reduce | Recommended
    private static void getTotalSalaryOfEmployeesBelongingToSEDepartment(List<Employee> employees)
    {
        Optional<Double> sumOfSalary = employees.stream()
                .filter(e -> e.getDepartment().equals("SE"))
                .map(e01 -> e01.getSalary())
                .reduce((s1, s2) -> s1+s2);
        sumOfSalary.ifPresent(System.out::println);
    }

    private static void countEmployeeByDepartment()
    {
        List<Employee> employees = getEmployees();
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(System.out::println);
    }

    // Sort Integer On The Basis Of Frequency
    private static void sortIntegerByFrequency()
    {
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,7,6,6,6,8,10,10,10,10,10,5,6,6,9,9);
        Map<Integer, Long> map = numbers
                .stream()
                .collect(Collectors.groupingBy(i-> i, Collectors.counting()));
        System.out.println("Sorted Integers:");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEach(m -> {
                    for(int i = 0; i< m.getValue(); i++)
                    {
                        System.out.print(m.getKey()+", ");
                    }
                });
    }

}
