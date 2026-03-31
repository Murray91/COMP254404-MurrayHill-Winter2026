package ex1;

class Exercise1 {

    // TreeNode is now static inner class
    static class TreeNode {
        int data;
        TreeNode left, right, parent;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }

    // Function to find inorder successor
    static TreeNode inorderNext(TreeNode p) {
        if (p == null) return null;

        // Case 1: right subtree exists
        if (p.right != null) {
            TreeNode curr = p.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        // Case 2: go up until node is left child
        TreeNode parent = p.parent;
        while (parent != null && p == parent.right) {
            p = parent;
            parent = parent.parent;
        }

        return parent;
    }

    // main method
    @SuppressWarnings("unused")
    static void main(String[] args) {
        // Build tree manually
        TreeNode root = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n15 = new TreeNode(15);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);

        root.left = n5;
        root.right = n15;
        n5.parent = root;
        n15.parent = root;

        n5.left = n3;
        n5.right = n7;
        n3.parent = n5;
        n7.parent = n5;

        // Test inorderNext
        TreeNode result = inorderNext(n5);

        if (result != null)
            System.out.println("Next of " + n5.data + " is " + result.data);
        else
            System.out.println("No next node");
    }
}