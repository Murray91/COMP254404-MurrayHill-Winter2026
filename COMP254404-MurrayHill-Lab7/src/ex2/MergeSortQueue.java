package ex2;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortQueue {

    // Merge two sorted queues
    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek())
                result.add(q1.poll());
            else
                result.add(q2.poll());
        }

        while (!q1.isEmpty())
            result.add(q1.poll());

        while (!q2.isEmpty())
            result.add(q2.poll());

        return result;
    }

    // Bottom-up merge sort
    public static Queue<Integer> mergeSort(int[] arr) {
        Queue<Queue<Integer>> queueOfQueues = new LinkedList<>();

        // Step 1: Each element in its own queue
        for (int num : arr) {
            Queue<Integer> singleQueue = new LinkedList<>();
            singleQueue.add(num);
            queueOfQueues.add(singleQueue);
        }

        // Step 2: Merge queues
        while (queueOfQueues.size() > 1) {
            Queue<Integer> q1 = queueOfQueues.poll();
            Queue<Integer> q2 = queueOfQueues.poll();

            Queue<Integer> merged = merge(q1, q2);
            queueOfQueues.add(merged);
        }

        return queueOfQueues.poll();
    }

    @SuppressWarnings({"unused", "ALL"})
    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 2, 9, 1};

        Queue<Integer> sorted = mergeSort(arr);

        System.out.println("=== Exercise 2: Bottom-Up Merge Sort (Queue) ===");
        System.out.print("Sorted Output: ");

        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}