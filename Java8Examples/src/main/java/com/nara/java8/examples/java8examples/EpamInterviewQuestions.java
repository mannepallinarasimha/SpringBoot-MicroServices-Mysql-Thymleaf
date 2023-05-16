package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EpamInterviewQuestions {
    //1. WAP to find highest continuous zeros in "101001"- output =2  , "1010010001" - output = 3
    //2.

    public static void main(String[] args) {
        String string = "101001000100000";
        Integer integer = Arrays.stream(string.split("1"))
                .skip(1)
                .toList()
                .stream()
                .map(m -> m.length())
                .sorted(Comparator.reverseOrder()) // sorted((o1,o2)-> o2.compareTo(o1))
                .toList()
                .stream().findFirst().get();
        System.out.println(integer);
    }

}
