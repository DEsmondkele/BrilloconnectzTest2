package org.example;

import org.example.pancake.PancakeShop;

public class Main {
    public static void main(String[] args) {

        PancakeShop.concurrentTask();
        System.out.println(); // empty line
        PancakeShop.nonConcurrentTask();
    }
}