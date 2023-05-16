package com.nara.java8.examples.java8examples;

 class Demo {

     public static void method1(){
         System.out.println("EpamQuestion : method1");
     }

     public void method2(){
         System.out.println("EpamQuestion : method2");
     }
}
class EpamQuestion1 {

    public static void method1(){
        System.out.println("EpamQuestion : method1");
    }

    public void method2(){
        System.out.println("EpamQuestion : method2");
    }
}

public class MainDemo{
    public static void main(String[] args) {
        Demo d1 = new Demo();
//        EpamQuestion1 d2 = new Demo(); //error here

        d1.method1();
        d1.method2();
//        d2.method1();
//        d2.method2();
    }
}