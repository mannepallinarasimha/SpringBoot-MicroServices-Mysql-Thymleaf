package com.nara.java8.examples.java8examples;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupBYSalaryAndDeptEmployee {
    public static List<Emp> empList = Stream.of(
            new Emp(1,"nara","DEV",50000),
            new Emp(2,"priya","DEV",60000),
            new Emp(3,"satya","QA",80000),
            new Emp(4,"ram","QA",30000),
            new Emp(5,"sam","DEVOPS",10000)
    ).toList();
    public static void main(String[] args) {
        //group by dept
        Map<String, List<Emp>> empDept = empList.stream().collect(Collectors.groupingBy(Emp::getDept));
        System.out.println(empDept);

        //Write compartor to comapre by salary
        Comparator<Emp> comparingBySalary = Comparator.comparing(Emp::getSalary);

        //main
        Map<String, Optional<Emp>> finalResultMap = empList.stream().collect(Collectors.groupingBy(
                Emp::getDept,
                Collectors.reducing(BinaryOperator.maxBy(comparingBySalary))
        ));

        System.out.println("Final Result : "+finalResultMap);

        //approrach -2
        Map<String, Emp> collect = empList.stream().collect(Collectors.groupingBy(
                Emp::getDept,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary)),
                        Optional::get)
        ));
        System.out.println("final:::: "+collect);

    }
}
