package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HighestSequenceOccurencesOfZerosCount {
    public static void main(String[] args) {
        String str = "101001000100000000";
        int length = Arrays.stream(str.split("1"))
                .skip(1)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get().length();
        System.out.println(length);
    }
}
