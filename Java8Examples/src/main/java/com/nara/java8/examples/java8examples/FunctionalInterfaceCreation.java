package com.nara.java8.examples.java8examples;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class Paytm implements FunctionalInterfaceCreation{
    @Override
    public String doPayment(String source, String destination) {
        String transactionDate = FunctionalInterfaceCreation.datePattern("yyyy-MM-dd");
        return null;
    }
}

class Amazon implements  FunctionalInterfaceCreation{

    @Override
    public String doPayment(String source, String destination) {
        return null;
    }


}
@FunctionalInterface
 interface FunctionalInterfaceCreation {

    public String doPayment(String source, String destination);

    default double getScrachCard() {
        return new Random().nextDouble();
    }
    static String datePattern(String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}

@FunctionalInterface
interface FunctionalInterfaceCreation1 {
    public String doPayment2();
}


