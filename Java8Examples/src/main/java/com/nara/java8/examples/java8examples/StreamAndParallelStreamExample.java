package com.nara.java8.examples.java8examples;

import java.io.InputStream;
import java.util.stream.IntStream;

public class StreamAndParallelStreamExample {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach(x -> System.out.println(Thread.currentThread().getName()+" - "+x));
        System.out.println("---------------");
        IntStream.rangeClosed(1,10).parallel().forEach(x -> System.out.println(Thread.currentThread().getName()+" - "+x));
    }
}
