package ex2;

class Exercise2 {

    // Node class as static inner class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Compute height and print during postorder traversal
    static int computeHeight(Node root) {
        if (root == null) return -1; // height of empty tree

        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        System.out.println("Node " + root.data + " -> Height: " + height);

        return height;
    }

    // main method
    @SuppressWarnings("unused")
    static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        computeHeight(root);
    }
}