// Java program that organizes and displays creatures based on their power levels and names using Bubble Sort, Selection Sort, and Stack.

import java.util.Stack; // Package to create a stack

public class Creature_Sort {
    // Input data
    static class Creature {
        String CreatureName;
        int PowerLevel;

        Creature(String CreatureName, int PowerLevel) {
            this.CreatureName = CreatureName;
            this.PowerLevel = PowerLevel;
        }

        @Override
        public String toString() {
            return CreatureName + " - " + PowerLevel;
        }
    }

    public static void main(String[] args) {
        Creature[] creatures = {
                // Creature names and their power levels
                new Creature("Dragon", 95),
                new Creature("Griffin", 88),
                new Creature("Unicorn", 78),
                new Creature("Phoenix", 92),
                new Creature("Centaur", 85)
        };

        // Bubble Sort Implementation (Descending Order)
        bubbleSortDescending(creatures);
        // Display the sorted list
        System.out.println("*** Bubble Sort: Descending Order by Power Level ***");
        for (Creature creature : creatures) {
            System.out.println(creature);
        }

        // Selection Sort Implementation (Ascending Order)
        selectionSortAscending(creatures);
        System.out.println("\n*** Selection Sort: Ascending Order by Power Level ***");
        for (Creature creature : creatures) {
            System.out.println(creature);
        }

        // Stack Implementation (Descending Order)
        Stack<Creature> stack = new Stack<>(); // Create a Stack
        for (Creature creature : creatures) {
            stack.push(creature); // Push all the creatures onto the stack
        }

        System.out.println("\n*** Stack Implementation: Popping Creatures ***");
        while (!stack.isEmpty()) {
            // Pop all the creatures from the stack
            System.out.println("Popped: " + stack.pop());
        }
    }

    // Array to implement a descending order 
    private static void bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int a = 0; a < n - 1 - i; a++) {
                if (creatures[a].PowerLevel < creatures[a + 1].PowerLevel) {
                    Creature temp = creatures[a];
                    creatures[a] = creatures[a + 1];
                    creatures[a + 1] = temp;
                }
            }
        }
    }

    // Array to implement an ascending order
    private static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int b = i + 1; b < n; b++) {
                if (creatures[b].PowerLevel < creatures[minIdx].PowerLevel) {
                    minIdx = b;
                }
            }
            Creature temp = creatures[minIdx];
            creatures[minIdx] = creatures[i];
            creatures[i] = temp;
        }
    }
}
