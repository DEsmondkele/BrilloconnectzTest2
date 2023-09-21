package org.example.pancake;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PancakeShop {
    public static void nonConcurrentTask() {
        int totalTime = 0;
        int pancakesMade = 0;
        int pancakesConsumed = 0;
        int ordersNotMet = 0;

        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            int userDemand = random.nextInt(6);
            int userConsumption = Math.min(userDemand, 5);
            int remainingPancakes = 12 - pancakesMade;

            if (userConsumption > remainingPancakes) {
                userConsumption = remainingPancakes;
                ordersNotMet++;
            }

            pancakesMade += userConsumption;
            pancakesConsumed += userConsumption;

            System.out.println("User A " + i + " wants to eat " + userDemand + " pancakes.");
            System.out.println("User A " + i + " eats " + userConsumption + " pancakes.");
        }

        totalTime += 30;
        System.out.println("Starting time: 0 seconds");
        System.out.println("Ending time: " + totalTime + " seconds");

        System.out.println("Shopkeeper A made " + pancakesMade + " pancakes.");
        System.out.println("Pancakes consumed: " + pancakesConsumed);
        System.out.println("Pancakes wasted: " + (pancakesMade - pancakesConsumed));
        System.out.println("Orders not met  By ShopKeeper A: " + ordersNotMet);
    }

    public static void concurrentTask() {
        int totalTimeTaken = 0;
        AtomicInteger pancakesMade = new AtomicInteger(0);
        AtomicInteger pancakesConsumed = new AtomicInteger(0);
        AtomicInteger ordersNotMet = new AtomicInteger(0);

        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            int userDemand = random.nextInt(6);
            int userConsumption = Math.min(userDemand, 5);
            int remainingPancakes = 12 - pancakesMade.get();

            if (userConsumption > remainingPancakes) {
                userConsumption = remainingPancakes;
                ordersNotMet.incrementAndGet();
            }

            pancakesMade.addAndGet(userConsumption);
            pancakesConsumed.addAndGet(userConsumption);

            System.out.println("User B " + i + " wants to eat " + userDemand + " pancakes.");
            System.out.println("User B " + i + " eats " + userConsumption + " pancakes.");
        }

        totalTimeTaken += 30;
        System.out.println("Starting time: 0 seconds");
        System.out.println("Ending time: " + totalTimeTaken + " seconds");

        System.out.println("Shopkeeper B made " + pancakesMade + " pancakes.");
        System.out.println("Pancakes consumed: " + pancakesConsumed);
        System.out.println("Pancakes wasted: " + (pancakesMade.get() - pancakesConsumed.get()));
        System.out.println("Orders not met By ShopKeeper B: " + ordersNotMet);
    }
}
