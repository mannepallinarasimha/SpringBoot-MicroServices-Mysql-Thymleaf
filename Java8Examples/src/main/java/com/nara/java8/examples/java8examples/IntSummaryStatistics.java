package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.List;

public class IntSummaryStatistics {
    public static void main(String[] args) {
        int[] intArrays = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        List<Integer> intList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        java.util.IntSummaryStatistics intSummaryStatistics = intList.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics);

    }
}
