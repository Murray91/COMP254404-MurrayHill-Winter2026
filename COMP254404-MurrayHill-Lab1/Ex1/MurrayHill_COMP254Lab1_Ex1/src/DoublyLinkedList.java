public class DoublyLinkedList<E> {

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, trailer.prev, trailer);
        trailer.prev.next = newest;
        trailer.prev = newest;
        size++;
    }

    public void printList() {
        Node<E> walk = header.next;
        while (walk != trailer) {
            System.out.print(walk.element + " ");
            walk = walk.next;
        }
        System.out.println();
    }

    // 👉 Concatenate method
    public static <E> DoublyLinkedList<E> concatenate(DoublyLinkedList<E> L, DoublyLinkedList<E> M) {
        DoublyLinkedList<E> result = new DoublyLinkedList<>();

        Node<E> walk = L.header.next;
        while (walk != L.trailer) {
            result.addLast(walk.element);
            walk = walk.next;
        }

        walk = M.header.next;
        while (walk != M.trailer) {
            result.addLast(walk.element);
            walk = walk.next;
        }

        return result;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();
        M.addLast(4);
        M.addLast(5);
        M.addLast(6);

        DoublyLinkedList<Integer> Lprime = concatenate(L, M);

        System.out.print("L': ");
        Lprime.printList();
    }
}

