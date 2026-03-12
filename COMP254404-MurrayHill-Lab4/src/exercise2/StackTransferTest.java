package exercise2;

import java.util.Stack;

class StackTransferTest {

    static <E> void transfer(Stack<E> S, Stack<E> T) {

        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    @SuppressWarnings("unused")
    static void main(String[] args) {

        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        System.out.println("Stack S before transfer: " + S);
        System.out.println("Stack T before transfer: " + T);

        transfer(S, T);

        System.out.println("Stack S after transfer: " + S);
        System.out.println("Stack T after transfer: " + T);
    }
}