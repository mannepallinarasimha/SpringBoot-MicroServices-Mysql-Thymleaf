package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SkipAndLimitExample {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //Now i want to print from 2 to 9
        numList.stream().skip(1).limit(8).forEach(System.out::println); //print 2-9
        System.out.println("---------");
        IntStream.range(1,20).skip(2).limit(18).forEach(System.out::println);//print 3 -19
        System.out.println("---------");
        IntStream.range(1,10).skip(2).limit(8).forEach(System.out::println);//print 3-9
    }
}
