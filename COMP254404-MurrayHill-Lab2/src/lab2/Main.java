package lab2;

import exercise1.Exercises;
import exercise2.PrefixAverages;
import exercise3.Uniqueness;

public class Main {

    public static void main(String[] args) {

        // Uncomment ONE at a time to run
        // runExercise1();
        // runExercise2();
         runExercise3();
    }

    // =========================
    // EXERCISE 1
    // =========================
    public static void runExercise1() {

        System.out.println("=================================");
        System.out.println("        EXERCISE 1 OUTPUT        ");
        System.out.println("=================================\n");

        System.out.println("----- example1 (O(n)) -----");
        Exercises.example1(5);
        System.out.println("\n-----------------------------\n");

        System.out.println("----- example2 (O(n^2)) -----");
        Exercises.example2(3);
        System.out.println("\n-----------------------------\n");

        System.out.println("----- example3 (O(n^2)) -----");
        Exercises.example3(4);
        System.out.println("\n-----------------------------\n");

        System.out.println("----- example4 (O(log n)) -----");
        Exercises.example4(16);
        System.out.println("\n-----------------------------\n");

        System.out.println("----- example5 (O(n log n)) -----");
        Exercises.example5(4);

        System.out.println("\n=================================");
        System.out.println("      END OF EXERCISE 1         ");
        System.out.println("=================================\n");
    }

    // =========================
    // EXERCISE 2
    // =========================
    public static void runExercise2() {

        int[] sizes = {1000, 2000, 4000, 8000};

        System.out.println("=================================");
        System.out.println("        EXERCISE 2 OUTPUT        ");
        System.out.println("=================================\n");

        System.out.println("PrefixAverage1 (O(n^2)):");
        for (int n : sizes) {
            double[] data = PrefixAverages.generateArray(n);

            long start = System.nanoTime();
            double[] result1 = PrefixAverages.prefixAverage1(data);
            long end = System.nanoTime();

            double time = (end - start) / 1_000_000.0;
            System.out.println("n = " + n + " Time = " + time + " ms");
        }

        System.out.println("\n-----------------------------\n");

        System.out.println("PrefixAverage2 (O(n)):");
        for (int n : sizes) {
            double[] data = PrefixAverages.generateArray(n);

            long start = System.nanoTime();
            double[] result2 = PrefixAverages.prefixAverage2(data);
            long end = System.nanoTime();

            double time = (end - start) / 1_000_000.0;
            System.out.println("n = " + n + " Time = " + time + " ms");
        }

        System.out.println("\n=================================");
        System.out.println("      END OF EXERCISE 2         ");
        System.out.println("=================================\n");
    }

    // =========================
    // EXERCISE 3
    // =========================
    public static void runExercise3() {

        System.out.println("=================================");
        System.out.println("        EXERCISE 3 OUTPUT        ");
        System.out.println("=================================\n");

        int n = 1000;
        int maxN1 = 0;

        System.out.println("Testing unique1 (O(n^2)):\n");

        while (true) {
            try {
                int[] data = Uniqueness.generateArray(n);

                long start = System.nanoTime();
                boolean result = Uniqueness.unique1(data);
                long end = System.nanoTime();

                long time = (end - start) / 1_000_000;
                System.out.println("n = " + n + " Time = " + time + " ms");

                if (time > 60000) break;

                maxN1 = n;
                n *= 2;

            } catch (OutOfMemoryError e) {
                System.out.println("Memory limit reached at n = " + n);
                break;
            }
        }

        System.out.println("\nMaximum n under 1 minute for unique1: " + maxN1);

        System.out.println("\n-----------------------------\n");

        n = 1000;
        int maxN2 = 0;

        System.out.println("Testing unique2 (O(n log n)):\n");

        while (true) {
            try {
                int[] data = Uniqueness.generateArray(n);

                long start = System.nanoTime();
                boolean result = Uniqueness.unique2(data);
                long end = System.nanoTime();

                long time = (end - start) / 1_000_000;
                System.out.println("n = " + n + " Time = " + time + " ms");

                if (time > 60000) break;

                maxN2 = n;
                n *= 5;

            } catch (OutOfMemoryError e) {
                System.out.println("Memory limit reached at n = " + n);
                break;
            }
        }

        System.out.println("\nMaximum n under 1 minute for unique2: " + maxN2);

        System.out.println("\n=================================");
        System.out.println("      END OF EXERCISE 3         ");
        System.out.println("=================================\n");
    }
}

