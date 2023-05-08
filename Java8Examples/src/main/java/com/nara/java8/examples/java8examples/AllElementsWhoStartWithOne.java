package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllElementsWhoStartWithOne {
    public static void main(String[] args) {
        int[] numbers = {2, 56, 34, 12, 11, 10, 19};
        List<String> collect = Arrays.stream(numbers).boxed()
                .sorted()
                .map(s -> s + "")
                .filter(x -> x.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("Start with One: "+collect);
    }
}
