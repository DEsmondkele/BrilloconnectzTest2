# BrilloconnectzTest2

Overview
This is a Java console-based program that simulates a pancake shop scenario. In this simulation, a shopkeeper is responsible for making pancakes, and there are three users who want to eat pancakes simultaneously. The simulation enforces the following rules:

Each user can eat a maximum of 5 pancakes within 30 seconds.
The shopkeeper can make a maximum of 12 pancakes every 30 seconds.
The program randomly determines the number of pancakes each user wants to eat within the 30-second period, but it cannot exceed the maximum of 5 pancakes per user. The simulation outputs the following information:

Starting time of the 30-second slots.
Ending time of the 30-second slots.
Whether the shopkeeper was able to meet the needs of the 3 users or not.
The number of pancakes wasted, if any.
The number of pancake orders that were not met if the shopkeeper couldn't fulfill all the orders.
Requirements
Java 11 or higher
Apache Maven

## Observations
- The non-concurrent version of the program runs sequentially, simulating the actions of the shopkeeper and users one after another. It may not be as efficient as the concurrent version.
- The concurrent version uses Java's synchronized keyword to manage access to shared resources (pancakes). This allows multiple users to request and consume pancakes simultaneously without conflicts.
- Both versions of the program adhere to the specified rules and provide the requested output.

## Usage
To run the program, follow these steps:

Clone this repository to your local machine:

```bash
git clone https://github.com/your-username/pancake-shop-simulation.git
cd BrilloconnectzJavaTest2
mvn clean package



