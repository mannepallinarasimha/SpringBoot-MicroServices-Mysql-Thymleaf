package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOccurencesofCharFromString {
    public static void main(String[] args) {
        String input = "narasimharaomannepalli";
        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
