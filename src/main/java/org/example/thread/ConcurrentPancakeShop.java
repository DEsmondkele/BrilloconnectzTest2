package org.example.thread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentPancakeShop {
    public static void main(String[] args) {
        int totalTime = 0;
        AtomicInteger pancakesMade = new AtomicInteger(0);
        AtomicInteger pancakesConsumed = new AtomicInteger(0);
        AtomicInteger ordersNotMet = new AtomicInteger(0);

        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            int userDemand = random.nextInt(6); // Random demand between 0 and 5 pancakes
            int userConsumption = Math.min(userDemand, 5); // Maximum 5 pancakes per user
            int remainingPancakes = 12 - pancakesMade.get();

            if (userConsumption > remainingPancakes) {
                userConsumption = remainingPancakes;
                ordersNotMet.incrementAndGet();
            }

            pancakesMade.addAndGet(userConsumption);
            pancakesConsumed.addAndGet(userConsumption);

            System.out.println("User " + i + " wants to eat " + userDemand + " pancakes.");
            System.out.println("User " + i + " eats " + userConsumption + " pancakes.");
        }

        totalTime += 30;
        System.out.println("Starting time: 0 seconds");
        System.out.println("Ending time: " + totalTime + " seconds");

        System.out.println("Shopkeeper made " + pancakesMade + " pancakes.");
        System.out.println("Pancakes consumed: " + pancakesConsumed);
        System.out.println("Pancakes wasted: " + (pancakesMade.get() - pancakesConsumed.get()));
        System.out.println("Orders not met: " + ordersNotMet);
    }
}
