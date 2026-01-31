public class SinglyLinkedList<E> {

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

    private Node<E> head = null;

    public void addFirst(E e) {
        head = new Node<>(e, head);
    }

    public void printList() {
        Node<E> walk = head;
        while (walk != null) {
            System.out.print(walk.element + " ");
            walk = walk.next;
        }
        System.out.println();
    }

    public void swapNodes(Node<E> node1, Node<E> node2) {
        if (node1 == node2) return;

        Node<E> prev1 = null, curr1 = head;
        while (curr1 != null && curr1 != node1) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        Node<E> prev2 = null, curr2 = head;
        while (curr2 != null && curr2 != node2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) return;

        if (prev1 != null) prev1.next = curr2;
        else head = curr2;

        if (prev2 != null) prev2.next = curr1;
        else head = curr1;

        Node<E> temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
    }

    public Node<E> getHead() {
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.print("Before swap: ");
        list.printList();

        Node<Integer> node1 = list.getHead().next;       // Node with 2
        Node<Integer> node2 = list.getHead().next.next.next; // Node with 4

        list.swapNodes(node1, node2);

        System.out.print("After swap: ");
        list.printList();
    }
}
