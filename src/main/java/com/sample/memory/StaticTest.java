package com.sample.memory;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Math.*;

public class StaticTest {

    public static LinkedHashSet<Double> list = new LinkedHashSet();

    public void populateList() {

        for (int i = 0; i < 10000000; i++) {

            if(i%1000 == 0) {
                System.out.println("Processed Count : " + i);
            }

            double randomValue  = random();
            if(list.contains(randomValue) == false ) {
                list.add(randomValue);
            }


        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Debug Point 1");
        Thread.sleep(10000);
        StaticTest staticTest = new StaticTest();
        staticTest.populateList();
        System.out.println("Debug Point 3");
        Thread.sleep(1000000);
    }
}