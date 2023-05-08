package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsFromString {
    public static void main(String[] args) {
        String input = "narasimharaomannepalli";
        List<String> collect = Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("Duplicates -having multiple occurences -in String are : "+collect);

        //remove duplicates
        List<String> RemoveDuplicates = Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        )).entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("NON - Duplicates  -have only one occurence- in String are : "+RemoveDuplicates);
    }
}
