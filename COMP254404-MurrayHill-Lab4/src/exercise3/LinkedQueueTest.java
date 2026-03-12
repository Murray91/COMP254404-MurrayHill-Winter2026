package exercise3;

class LinkedQueueTest {

    static class Node<E> {
        E element;
        Node<E> next;

        Node(E e) {
            element = e;
            next = null;
        }
    }

    static class LinkedQueue<E> {

        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        boolean isEmpty() {
            return size == 0;
        }

        void enqueue(E e) {

            Node<E> newest = new Node<>(e);

            if (isEmpty()) {
                head = newest;
            } else {
                tail.next = newest;
            }

            tail = newest;
            size++;
        }

        E dequeue() {

            if (isEmpty())
                return null;

            E answer = head.element;
            head = head.next;
            size--;

            if (isEmpty())
                tail = null;

            return answer;
        }

        void concatenate(LinkedQueue<E> Q2) {

            if (Q2.isEmpty())
                return;

            if (this.isEmpty()) {
                this.head = Q2.head;
            } else {
                this.tail.next = Q2.head;
            }

            this.tail = Q2.tail;
            this.size += Q2.size;

            // empty Q2
            Q2.head = null;
            Q2.tail = null;
            Q2.size = 0;
        }

        void printQueue() {

            Node<E> current = head;

            while (current != null) {
                System.out.print(current.element + " ");
                current = current.next;
            }

            System.out.println();
        }
    }

    @SuppressWarnings("unused")
    static void main(String[] args) {

        LinkedQueue<Integer> Q1 = new LinkedQueue<>();
        LinkedQueue<Integer> Q2 = new LinkedQueue<>();

        Q1.enqueue(10);
        Q1.enqueue(20);
        Q1.enqueue(30);

        Q2.enqueue(40);
        Q2.enqueue(50);
        Q2.enqueue(60);

        System.out.print("Queue 1 before: ");
        Q1.printQueue();

        System.out.print("Queue 2 before: ");
        Q2.printQueue();

        Q1.concatenate(Q2);

        System.out.print("Queue 1 after: ");
        Q1.printQueue();

        System.out.print("Queue 2 after: ");
        Q2.printQueue();

        // use dequeue so method is not unused
        System.out.println("Dequeued from Queue 1: " + Q1.dequeue());
    }
}