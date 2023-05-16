package com.nara.java8.examples.java8examples;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee123{
    private Long id;
    private String name;
}
public class EpamListExample {
    public static void main(String[] args) {
        final List<Employee123> empList = new ArrayList<>();
        empList.add(new Employee123(1l, "nara"));
        empList.add(new Employee123(2l, "priya"));
        System.out.println(empList);
    }
}
