package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FindHighestNumberFromArray {
    public static void main(String[] args) {
        int[] numbers = {10, 200, 30, 40, 11, 6, 1, 23, 55};
        Integer integer = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get();
        System.out.println(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
        System.out.println("First Highest number is : "+integer);

        //second highest number
        Integer integer1 = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Second Highest Number is : "+integer1);

        //third highest number
        Integer integer2 = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .get();
        System.out.println("Third Highest Number is : "+integer2);
    }
}
