package ex1;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Insert method
    Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    // Non-recursive search
    boolean search(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.data)
                return true;
            else if (key < current.data)
                current = current.left;
            else
                current = current.right;
        }

        return false;
    }
}

public class BSTNonRecursive {

    @SuppressWarnings({"unused", "ALL"})
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        // The tree
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        // I/O output
        System.out.println("=== Exercise 1: Non-Recursive BST Search ===");

        int key1 = 40;
        int key2 = 90;

        System.out.println("Searching for " + key1 + ": " + tree.search(key1));
        System.out.println("Searching for " + key2 + ": " + tree.search(key2));
    }
}