package com.nara.java8.examples.java8examples;

import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

@FunctionalInterface
interface MyFunction{
    void test();
}

@FunctionalInterface
interface MyFunction1{
    int test(int a);
}
@FunctionalInterface
interface MyFunction2{
    int test(int a, int b);
}
public class LanmdaExample {
    public static void main(String[] args) {
        MyFunction weRInTestMethod = () -> System.out.println("we r in test method");
        weRInTestMethod.test();

        MyFunction1 myFunction1 = (int a) ->  a;
        System.out.println(myFunction1.test(10));

        MyFunction2 myFunction2 = (int a, int b) -> (a + b);
        int test = myFunction2.test(3, 6);
        System.out.println(test);
    }
}
