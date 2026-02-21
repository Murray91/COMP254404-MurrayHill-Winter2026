package ex1;

/**
 * Exercise 1
 * Computes product of two positive integers using recursion,
 * only addition and subtraction.
 */
public class RecursiveProduct {

    public static int recursiveProduct(int m, int n) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Recursive case
        return m + recursiveProduct(m, n - 1);
    }
}