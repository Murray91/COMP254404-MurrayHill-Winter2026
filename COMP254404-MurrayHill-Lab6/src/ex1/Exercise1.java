package ex1;

import java.util.Random;

class Exercise1 {

    static class HashMapCustom {
        private Integer[] table;
        private int size = 0;
        private final double maxLoadFactor;

        HashMapCustom(int capacity, double loadFactor) {
            table = new Integer[capacity];
            this.maxLoadFactor = loadFactor;
        }

        private int hash(int key) {
            return Math.abs(key) % table.length;
        }

        public void put(int key) {
            int index = hash(key);


            while (table[index] != null) {
                index = (index + 1) % table.length;
            }

            table[index] = key;
            size++;

            if ((double) size / table.length > maxLoadFactor) {
                resize();
            }
        }

        private void resize() {
            Integer[] old = table;
            table = new Integer[old.length * 2];
            size = 0;

            for (Integer key : old) {
                if (key != null) {
                    put(key);
                }
            }

            System.out.println("Resized to capacity: " + table.length);
        }

        public double getLoadFactor() {
            return (double) size / table.length;
        }
    }

    @SuppressWarnings("unused")
    static void main(String[] args) {
        testLoadFactor(0.5);
        testLoadFactor(0.7);
        testLoadFactor(0.9);
    }

    static void testLoadFactor(double loadFactor) {
        System.out.println("\n--- Testing Load Factor: " + loadFactor + " ---");

        Random rand = new Random();
        HashMapCustom map = new HashMapCustom(10, loadFactor);

        for (int i = 0; i < 15; i++) {
            int key = rand.nextInt(100);
            map.put(key);
            System.out.println("Inserted: " + key + " | Load: " + map.getLoadFactor());
        }
    }
}