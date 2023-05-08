package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringJoinMethod {
    public static void main(String[] args) {
        String[] stringArray = {"1","2","3","4"};
        String join = String.join("-", stringArray);
        System.out.println("Join using String.join method:: "+join);

        //Using Stream
        String collect = Arrays.stream(stringArray).collect(Collectors.joining("-"));
        System.out.println("Using Stream API::: "+collect);
    }
}
