package com.sample.memory;

import java.util.List;
import java.util.ArrayList;

public class StaticTest {
    public static List<Double> list = new ArrayList();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) {
        System.out.println("Debug Point 1");
        new StaticTest().populateList();
        System.out.println("Debug Point 3");
    }
}