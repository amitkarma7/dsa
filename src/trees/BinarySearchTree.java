package trees;

import java.util.*;
import java.util.stream.Collectors;

public class BinarySearchTree {

    public Node getRoot() {
        return root;
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
                break;
            case "inorder":
                displayInOrder(root, "Root Node : ");
                break;
            case "postOrder":
                displayPostOrder(root, "Root Node : ");
                break;

        }
    }

    private void displayPreOrder(Node node, String details) {
        if (node == null) return;

        System.out.println(details + node.data);
        displayPreOrder(node.left, "Left child of " + node.data + " : ");
        displayPreOrder(node.right, "Right child of " + node.data + " : ");

    }
    Node prev;
    private void displayInOrder(Node node, String details) {
        if (node == null) return;
        displayInOrder(node.left, "Left child of " + node.data + " : ");
//        System.out.println(details + node.data);
        if(prev != null) System.out.println("prev    " + prev.data);
        prev = node;
        displayInOrder(node.right, "Right child of " + node.data + " : ");
    }

    private void displayPostOrder(Node node, String details) {
        if (node == null) return;
        displayPostOrder(node.left, "Left child of " + node.data + " : ");
        displayPostOrder(node.right, "Right child of " + node.data + " : ");
        System.out.println(details + node.data);
    }

    public Node insert(Integer value) {
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


    public static long kthLargestLevelSum(Node root, int k) {

        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        long max = Long.MIN_VALUE ;
        while(!queue.isEmpty()) {
            int lvl =  queue.size();
            long curentSum = 0;
            for(int i=0;i< lvl;i++) {
                Node curr = queue.poll();
                curentSum+=curr.data;
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (minHeap.size() < k) {
                minHeap.offer(curentSum);
            } else if (curentSum > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(curentSum);
            }        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        BinarySearchTree bSearchTree = new BinarySearchTree();
//        bSearchTree.pupulate(new int[]{12, 54, 3, 2, 1, 66, 63, 44, 22});
//        bSearchTree.display("preorder");
//        System.out.println(bSearchTree.balanced());
//        bSearchTree.root = null;
//        System.out.println("pupulate print");
//        bSearchTree.pupulate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        bSearchTree.display("preorder");
//        bSearchTree.root = null;
//        System.out.println("populateSorted print");
//        bSearchTree.populateSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        bSearchTree.display("inorder");
        bSearchTree.pupulate(new int[]{5,8,9,2,1,3,7,4,6});

        System.out.println(kthLargestLevelSum(bSearchTree.root,2));;

    }


}
