package com.nara.java8.examples.java8examples;

public class RunnableFunctionInterfaceExcaple {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("we r in run method");
            }
        };

        //using Lamda Expression(Copy overrided method and take method parameters -> {stmts})
        Runnable r = () -> System.out.println("we r in run method");
        new Thread(r).start();


    }
}
