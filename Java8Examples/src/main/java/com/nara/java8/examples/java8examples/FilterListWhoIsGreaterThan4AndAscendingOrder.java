package com.nara.java8.examples.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterListWhoIsGreaterThan4AndAscendingOrder {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,29,30,3,6,28,56,100,2,1);
        List<Integer> collect = list.stream()  //adding to stream() API
                .filter(x -> x > 4)  //filter to get greatethan 4 values
                .sorted()   //sorted to get Ascending order
                .toList(); // collecting to list to print (if we NOT collect to list it will print Stream of Integers)
        System.out.println("Filter List Who Is Greater Than 4 And Ascending Order : "+collect);

        list.stream().filter(x -> x>5).sorted().forEach(FilterListWhoIsGreaterThan4AndAscendingOrder::printElement);
    }
    //defining our own static method for method reference
    public static void  printElement(int i){
        System.out.println(i);
    }
}
