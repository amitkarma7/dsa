package trees;

public class BinarySearchTree {
    public static class Node  {
        private int data;
        private int ht;
        private Node left,right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public int height(Node node) {
        if(node == null) return -1;
        return node.ht;
    }

    public boolean isEnpty() {
        return root== null;
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node,  String details) {
        if(node == null) return;

        System.out.println(details + node.data);
        display(node.left, "Left child of " + node.data + " ");
        display(node.right, "Right child of " + node.data + " ");

    }
    private Node insert(int value) {
        root = insert(root,value);
        return root;
    }
    private Node insert(Node node ,int value) {
        if(node ==null) {
            node= new Node(value);
            return node;
        }
        if(value > node.data) node.right = insert(node.right,value);
        else node.left = insert(node.left,value);
        node.ht = Math.max(height(node.left),height(node.right)) +1; // calculate height of nodes

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {

        if(node ==null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bSearchTree = new BinarySearchTree();
        bSearchTree.root =new Node(10);
        bSearchTree.insert(20);
        bSearchTree.insert(5);
        bSearchTree.insert(4);
        bSearchTree.insert(8);
        bSearchTree.insert(19);
        bSearchTree.insert(22);
        bSearchTree.insert(3);


        bSearchTree.display();
        System.out.println(bSearchTree.balanced());

    }
}
