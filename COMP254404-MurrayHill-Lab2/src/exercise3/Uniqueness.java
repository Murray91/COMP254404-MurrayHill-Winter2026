package exercise3;

import java.util.Random;
import java.util.Arrays;

public class Uniqueness {

    // O(n^2)
    public static boolean unique1(int[] data) {
        int n = data.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (data[i] == data[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n log n)
    public static boolean unique2(int[] data) {
        Arrays.sort(data);

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == data[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }

        return arr;
    }
}
