package trees;

import static java.util.Collections.rotate;

public class AVLTree {


    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node insert(int value) {
        root = insert(root, value);
        return root;
    }

    private Node insert(Node root, int value) {
        if (root == null) return root = new Node(value);

        if (value > root.data) {
            root.right = insert(root.right, value);
        } else {
            root.left = insert(root.left, value);
        }
        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        return rotate(root);

    }

    private Node rotate(Node node) {

        if (height(node.left) - height(node.right) > 1) {
            // left heavy

            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left case
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy

            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right case
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right)  > 0) {
                // left-right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;
        p.ht = Math.max( height(p.left) , height(p.right) + 1 ); // for right height +1 ;
        c.ht = Math.max( height(c.left) , height(c.right) + 1 ) ; // for right height +1 ;
        return c;
    }

    private Node leftRotate(Node c) {

        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;
        p.ht = Math.max( height(p.left) , height(p.right) + 1 ); // for right height +1 ;
        c.ht = Math.max( height(c.left) , height(c.right) + 1 ) ; // for right height +1 ;
        return p;
    }


    boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return  Math.abs(height(node.left) - height(node.right))  <= 1 &&
                balanced(node.left) &&
                balanced(node.right);
    }

    private int height(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    public int height() {
        return height(root);
    }
    private boolean isEmpty(Node node) {
        return node == null;
    }
}
