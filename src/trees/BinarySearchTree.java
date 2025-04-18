package trees;

import java.util.Arrays;

public class BinarySearchTree {
    public static class Node {
        private int data;
        private int ht;
        private Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public int height(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    public boolean isEnpty() {
        return root == null;
    }

    public void display(String value) {
        switch (value) {
            case "preorder":
                displayPreOrder(root, "Root Node : ");
            case "inorder":
                displayInOrder(root, "Root Node : ");
            case "postOrder":
                displayPostOrder(root, "Root Node : ");

        }
    }

    private void displayPreOrder(Node node, String details) {
        if (node == null) return;

        System.out.println(details + node.data);
        displayPreOrder(node.left, "Left child of " + node.data + " : ");
        displayPreOrder(node.right, "Right child of " + node.data + " : ");

    }

    private void displayInOrder(Node node, String details) {
        if (node == null) return;
        displayInOrder(node.left, "Left child of " + node.data + " : ");
        System.out.println(details + node.data);
        displayInOrder(node.right, "Right child of " + node.data + " : ");
    }

    private void displayPostOrder(Node node, String details) {
        if (node == null) return;
        displayPostOrder(node.left, "Left child of " + node.data + " : ");
        displayPostOrder(node.right, "Right child of " + node.data + " : ");
        System.out.println(details + node.data);
    }

    private Node insert(int value) {
        root = insert(root, value);
        return root;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value > node.data) node.right = insert(node.right, value);
        else node.left = insert(node.left, value);
        node.ht = Math.max(height(node.left), height(node.right)) + 1; // calculate height of nodes

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {

        if (node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                balanced(node.left) && balanced(node.right);
    }

    void pupulate(int[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            insert(nodes[i]);
        }
    }

    public void populateSorted(int[] nodes) {
        populateSorted(nodes, 0, nodes.length);
    }

    private void populateSorted(int[] nodes, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        insert(nodes[mid]);
        populateSorted(nodes, start, mid);
        populateSorted(nodes, mid + 1, end);


    }

    public static void main(String[] args) {
        BinarySearchTree bSearchTree = new BinarySearchTree();
        bSearchTree.pupulate(new int[]{12, 54, 3, 2, 1, 66, 63, 44, 22});
        bSearchTree.display("preorder");
        System.out.println(bSearchTree.balanced());
        bSearchTree.root = null;
        System.out.println("pupulate print");
        bSearchTree.pupulate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        bSearchTree.display("preorder");
        bSearchTree.root = null;
        System.out.println("populateSorted print");
        bSearchTree.populateSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        bSearchTree.display("inorder");

    }
}
