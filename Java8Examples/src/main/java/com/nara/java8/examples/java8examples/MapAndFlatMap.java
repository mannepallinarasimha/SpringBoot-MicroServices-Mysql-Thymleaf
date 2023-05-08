package com.nara.java8.examples.java8examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee{
    private long id;
    private String name;
    private List<String> phone;
    private String email;

}

class EmployeeDB{
    public static List<Employee> getAllEmployees(){
        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"Narasimha",Arrays.asList("9032787872","9999999999"), "Narasimha@gmail.com"),
                new Employee(2,"Priyanka",Arrays.asList("9032787872","8888888888"), "Priyanka@gmail.com"),
                new Employee(3,"Satya",Arrays.asList("9032787872","777777"), "Satya@gmail.com"),
                new Employee(4,"Ramya",Arrays.asList("9032787872","666666666"), "Ramya@gmail.com"),
                new Employee(5,"Rohit",Arrays.asList("9032787872","55555555"), "Rohit@gmail.com"),
                new Employee(6,"Sai",Arrays.asList("9032787872","4444444"), "Sai@gmail.com")
        );
        return employeeList;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Emp{
    private int id;
    private String name;
    private String dept;
    private int salary;
}
public class MapAndFlatMap {

    public static List<Emp> empList = Stream.of(
            new Emp(1,"nara","DEV",100000),
            new Emp(2,"priya","DEV",70000),
            new Emp(3,"satya","QA",40000),
            new Emp(4,"ram","QA",80000),
            new Emp(5,"sam","QA",20000),
            new Emp(6,"raghava","DEVOPS",10010)
    ).toList();
    public static void main(String[] args) {
        List<Employee> allEmployees = EmployeeDB.getAllEmployees();
        List<String> OneToOneMapping = allEmployees.stream()
                .map(emp -> emp.getEmail())  //here we have one emp has one email and return as another stream --> One to One mapping
                .collect(Collectors.toList());
        System.out.println("OneToOneMapping :: "+OneToOneMapping);

        //Here we are getting Stream of Stream as Return type but we required Single Stream as retun output --> So we have to use flatMap()
        List<List<String>> collect = allEmployees.stream().map(emp -> emp.getPhone()).collect(Collectors.toList());
        System.out.println("Stream of Stream returning if we use map() ::: "+collect);

        //One to Many mapping -->> One Employee contains many Phone numbers
        List<String> onetoManyMapping = allEmployees.stream().flatMap(emp -> emp.getPhone().stream()).collect(Collectors.toList());
        System.out.println("onetoManyMapping   :::"+onetoManyMapping);

        List<String> list = allEmployees.stream().map(Employee::getEmail).toList();
        System.out.println("List of emails : "+list);

        List<String> list1 = allEmployees.stream().flatMap(x -> x.getPhone().stream()).toList();
        System.out.println("List of phones : "+list1);

        String str = "Narasimha";
        Map<String, Long> collect1 = stream(str.split("")).collect(groupingBy(
                identity(),LinkedHashMap::new,  counting()
        ));
        System.out.println(collect1);

        Integer integer = empList.stream().map(Emp::getSalary).toList().stream()
                .reduce((n1, n2) -> n1 > n2 ? n1 : n2).get();
        System.out.println("Higest employee Paid : "+integer);// will get only salary

        //first get depts by group
        Map<String, List<Emp>> employeeByDeptGroup = empList.stream().collect(groupingBy(Emp::getDept));
        System.out.println("Employees by Dept: "+employeeByDeptGroup);

        //second we need comparator to get salary comparision
        Comparator<Emp> compareBySalary = Comparator.comparing(Emp::getSalary);

        //Now passing comparator to max()
        Map<String, Optional<Emp>> map = empList.stream().collect(groupingBy(
                Emp::getDept,
                Collectors.reducing(BinaryOperator.minBy(compareBySalary))
        ));
        System.out.println("Final output:: "+map);
    }

}
