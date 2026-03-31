package ex3;

import java.util.ArrayList;

class Exercise3 {

    static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        private int parent(int i) {
            return (i - 1) / 2;
        }

        public void insert(int value) {
            heap.add(value);
            upheap(heap.size() - 1);
        }

        // Recursive upheap
        private void upheap(int i) {
            if (i == 0) return;

            int parentIndex = parent(i);

            if (heap.get(i) < heap.get(parentIndex)) {
                // swap
                int temp = heap.get(i);
                heap.set(i, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                // recursive call
                upheap(parentIndex);
            }
        }

        public void printHeap() {
            System.out.println(heap);
        }
    }

    // main method
    @SuppressWarnings("unused")
    static void main(String[] args) {
        Heap pq = new Heap();

        pq.insert(20);
        pq.insert(5);
        pq.insert(15);
        pq.insert(2);

        pq.printHeap();
    }
}