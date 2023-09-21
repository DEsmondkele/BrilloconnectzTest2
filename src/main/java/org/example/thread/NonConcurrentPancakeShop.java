package org.example.thread;

import java.util.Random;

public class NonConcurrentPancakeShop {
    public static void main(String[] args) {
        int totalTime = 0;
        int pancakesMade = 0;
        int pancakesConsumed = 0;
        int ordersNotMet = 0;

        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            int userDemand = random.nextInt(6); // Random demand between 0 and 5 pancakes
            int userConsumption = Math.min(userDemand, 5); // Maximum 5 pancakes per user
            int remainingPancakes = 12 - pancakesMade;

            if (userConsumption > remainingPancakes) {
                userConsumption = remainingPancakes;
                ordersNotMet++;
            }

            pancakesMade += userConsumption;
            pancakesConsumed += userConsumption;

            System.out.println("User " + i + " wants to eat " + userDemand + " pancakes.");
            System.out.println("User " + i + " eats " + userConsumption + " pancakes.");
        }

        totalTime += 30;
        System.out.println("Starting time: 0 seconds");
        System.out.println("Ending time: " + totalTime + " seconds");

        System.out.println("Shopkeeper made " + pancakesMade + " pancakes.");
        System.out.println("Pancakes consumed: " + pancakesConsumed);
        System.out.println("Pancakes wasted: " + (pancakesMade - pancakesConsumed));
        System.out.println("Orders not met: " + ordersNotMet);
    }
}
