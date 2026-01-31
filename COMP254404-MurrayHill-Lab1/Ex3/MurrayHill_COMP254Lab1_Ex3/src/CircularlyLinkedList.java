public class CircularlyLinkedList<E> {

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.next = tail;
        } else {
            Node<E> newest = new Node<>(e, tail.next);
            tail.next = newest;
        }
        size++;
    }

    public void printList() {
        if (tail == null) return;
        Node<E> walk = tail.next;
        do {
            System.out.print(walk.element + " ");
            walk = walk.next;
        } while (walk != tail.next);
        System.out.println();
    }

    public CircularlyLinkedList<E> clone() {
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        if (tail == null) return other;

        Node<E> walk = tail.next;
        do {
            other.addFirst(walk.element);
            walk = walk.next;
        } while (walk != tail.next);

        return other;
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.print("Original: ");
        list.printList();

        CircularlyLinkedList<Integer> cloned = list.clone();

        System.out.print("Cloned: ");
        cloned.printList();
    }
}

