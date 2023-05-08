package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeateElementInString {
    public static void main(String[] args) {
        String input = "narasimharao"; //here non-repeate is 'n'
        String s = Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))   //we will get All occurences upto here
                .entrySet()    //to get only key or value
                .stream()
                .filter(x -> x.getValue() == 1) //if you want use filter have to use stream
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println("First Non-repeated char is : "+s);

        //find first repeated char
        String s1 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println("First Repeated char is : "+s1);

    }
}
