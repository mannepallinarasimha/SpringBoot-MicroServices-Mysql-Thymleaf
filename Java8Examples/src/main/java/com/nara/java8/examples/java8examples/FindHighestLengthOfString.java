package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.List;

public class FindHighestLengthOfString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("nara", "pu","i love you ","narasimharao","satya dhanvin mannepalli");
        String s = stringList.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println("Highest Length String is : "+s);
    }
}
