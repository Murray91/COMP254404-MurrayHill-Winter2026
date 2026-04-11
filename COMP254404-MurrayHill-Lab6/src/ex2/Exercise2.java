package ex2;

import java.util.ArrayList;

class Exercise2 {

    static class SortedTableMap {
        private final ArrayList<Entry> table = new ArrayList<>();

        static class Entry {
            int key;
            String value;

            Entry(int k, String v) {
                key = k;
                value = v;
            }
        }

        private int findIndex(int key) {
            int low = 0, high = table.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (table.get(mid).key == key)
                    return mid;
                else if (table.get(mid).key < key)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            return -(low + 1); // insertion point
        }

        public void put(int key, String value) {
            int index = findIndex(key);

            if (index >= 0)
                table.get(index).value = value;
            else
                table.add(-index - 1, new Entry(key, value));
        }

        // REQUIRED METHOD
        public boolean containsKey(int key) {
            return findIndex(key) >= 0;
        }
    }

    @SuppressWarnings("unused")
    static void main(String[] args) {
        SortedTableMap map = new SortedTableMap();

        map.put(10, "A");
        map.put(5, "B");
        map.put(20, "C");

        System.out.println("Contains 10: " + map.containsKey(10));
        System.out.println("Contains 7: " + map.containsKey(7));
    }
}