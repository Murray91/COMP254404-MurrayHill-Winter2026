package exercise2;

import java.util.Random;

public class PrefixAverages {

    // O(n^2)
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];

        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++) {
                total += x[i];
            }
            a[j] = total / (j + 1);
        }
        return a;
    }

    // O(n)
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;

        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;
    }

    public static double[] generateArray(int n) {
        Random rand = new Random();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextDouble();
        }

        return arr;
    }
}
