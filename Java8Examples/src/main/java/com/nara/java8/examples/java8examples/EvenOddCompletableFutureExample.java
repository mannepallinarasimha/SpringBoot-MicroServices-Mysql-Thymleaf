package com.nara.java8.examples.java8examples;

import lombok.Synchronized;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddCompletableFutureExample {
    private static Object object = new Object();

    public static void execute(int number) throws InterruptedException {
        //synchronoze object first

//        Synchronized (object) {
//            System.out.println(Thread.currentThread().getName()+" : "+number);
//            object.notify();
//            object.wait();
//        }
    }

    //create two static methods
    private static IntPredicate evenCondition = e -> e %2 ==0;
    private static IntPredicate oddCondition = o -> o %2 !=1;
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync( () -> {
            try {
                EvenOddCompletableFutureExample.printNumber(evenCondition);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture.runAsync(() -> {
            try {
                EvenOddCompletableFutureExample.printNumber(oddCondition);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(1000);
    }
    public static void printNumber(IntPredicate condition)throws InterruptedException{
        try{
            //IntStream.rangeClosed(1,10).filter(condition).forEach(EvenOddCompletableFutureExample::execute);
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


}
