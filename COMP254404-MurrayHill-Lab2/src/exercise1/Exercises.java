package exercise1;

public class Exercises {

    // O(n)
    public static void example1(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    // O(n^2)
    public static void example2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "," + j);
            }
        }
    }

    // O(n^2)
    public static void example3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(i + "," + j);
            }
        }
    }

    // O(log n)
    public static void example4(int n) {
        int i = 1;
        while (i < n) {
            System.out.println(i);
            i *= 2;
        }
    }

    // O(n log n)
    public static void example5(int n) {
        for (int i = 0; i < n; i++) {
            example4(n);
        }
    }
}
