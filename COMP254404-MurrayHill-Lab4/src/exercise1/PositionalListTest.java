package exercise1;

import java.util.LinkedList;

class PositionalListTest {

    @SuppressWarnings("ClassCanBeRecord")
    static class Position<E> {
        private final E element;

        Position(E e) {
            this.element = e;
        }

        E getElement() {
            return element;
        }
    }

    static class PositionalList<E> {

        private final LinkedList<Position<E>> list = new LinkedList<>();

        Position<E> addLast(E e) {
            Position<E> p = new Position<>(e);
            list.add(p);
            return p;
        }

        Position<E> first() {
            if (list.isEmpty()) return null;
            return list.getFirst();
        }

        Position<E> after(Position<E> p) {
            int index = list.indexOf(p);
            if (index == -1 || index + 1 >= list.size()) return null;
            return list.get(index + 1);
        }

        int indexOf(Position<E> p) {
            int index = 0;
            Position<E> current = first();
            while (current != null) {
                if (current == p) return index;
                current = after(current);
                index++;
            }
            return -1;
        }
    }

    @SuppressWarnings("unused")
    static void main(String[] args) {

        PositionalList<String> list = new PositionalList<>();

        Position<String> p1 = list.addLast("A");
        Position<String> p2 = list.addLast("B");
        Position<String> p3 = list.addLast("C");
        Position<String> p4 = list.addLast("D");

        System.out.println(p1.getElement() + " index: " + list.indexOf(p1));
        System.out.println(p2.getElement() + " index: " + list.indexOf(p2));
        System.out.println(p3.getElement() + " index: " + list.indexOf(p3));
        System.out.println(p4.getElement() + " index: " + list.indexOf(p4));
    }
}