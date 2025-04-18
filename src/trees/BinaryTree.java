package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
   static int idx = -1;
    class Node {
        private int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    Node buildTree(int nodes[]) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left =  buildTree(nodes);
        newNode.right =  buildTree(nodes);
        return newNode;
    }

    void preOrder(Node node) {
        if(node ==null) {
            return;
        }
        System.out.print(node.data+ " ");
        preOrder(node.left);
        preOrder(node.right);

    }


    void inOrder(Node node) {
        if(node ==null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }

    void postOrder(Node node) {
        if(node ==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }


    void levelOrder(Node node) {
        if(node ==null) {
            return;
        }
        Queue<Node> nodes =new LinkedList<>();
        nodes.add(node);
        nodes.add(null);
        while(!nodes.isEmpty()) {
            Node currentNode = nodes.remove();
            if(currentNode ==null) {
                System.out.println();
                 if(nodes.isEmpty()) {
                     break;
                 }else {
                     nodes.add(null);
                 }
            } else {
                System.out.print(currentNode.data + " ");
                if(currentNode.left !=null)  {
                    nodes.add(currentNode.left);
                }
                if(currentNode.right !=null)  {
                    nodes.add(currentNode.right);
                }
            }

        }
    }

    int countOfNodes(Node root) {
        if(root == null) return 0;
        int leftNodesCount = this.countOfNodes(root.left);
        int rightNodesCount = this.countOfNodes(root.right);
        return  leftNodesCount+rightNodesCount+1;
    }

    int sumOfNodes(Node root) {
        if(root == null) return 0;
        return root.data + this.sumOfNodes(root.right) + this.sumOfNodes(root.left);
    }

    int heightOfNode(Node root) {
        if(root == null) return 0;
        int leftNodeHeight = this.heightOfNode(root.left);
        int rightNodeHeight = this.heightOfNode(root.right);
        return Math.max(leftNodeHeight, rightNodeHeight) +1;
    }

//   time complexcity is O(n^2)
    int diameter(Node root) {
        if(root == null) return 0;
        int leftNode = this.diameter(root.left);
        int rightNode = this.diameter(root.right);
        int totalHeightOfNode = this.heightOfNode(root.left) +
                this.heightOfNode(root.right) +1 ;
        return Math.max( totalHeightOfNode, Math.max(leftNode, rightNode));
    }

    class TreeInfo {
        int ht;
        int diameter;

        public TreeInfo(int ht, int diameter) {
            this.ht = ht;
            this.diameter = diameter;
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "ht=" + ht +
                    ", diameter=" + diameter +
                    '}';
        }
    }
    //   time complexcity is O(n)
    TreeInfo diameter2(Node root) {
        if(root == null) return new TreeInfo(0,0);
        TreeInfo leftNode = this.diameter2(root.left);
        TreeInfo rightNode = this.diameter2(root.right);
        int totalHeightOfNode = Math.max(leftNode.ht ,rightNode.ht) +1 ;

        int diameter1 = leftNode.diameter;
        int diameter2 = rightNode.diameter;
        int diameter3 = leftNode.ht  + rightNode.ht +1;

        int newDiameter = Math.max(diameter3 , Math.max(diameter1,diameter2));

        return new TreeInfo(totalHeightOfNode,newDiameter);
    }





    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        if(Integer.valueOf(1)==null) {

        }
        BinaryTree binaryTree =new BinaryTree();
        Node root =  binaryTree.buildTree(nodes);
        System.out.println("Print Pre Order");
        binaryTree.preOrder(root);
        System.out.println("\nPrint In Order");
        binaryTree.inOrder(root);
        System.out.println("\nPrint Post Order");
        binaryTree.postOrder(root);

        System.out.println("\nPrint level Order");
        binaryTree.levelOrder(root);

        System.out.println("\nPrint count nodes "  + binaryTree.countOfNodes(root));
        System.out.println("\nPrint Sum nodes "  + binaryTree.sumOfNodes(root));

        System.out.println("\nPrint heightOfNode "  + binaryTree.heightOfNode(root));
        System.out.println("\nPrint diameter "  + binaryTree.diameter(root));

        System.out.println("\nPrint diameter 2 "  + binaryTree.diameter2(root));


    }
}
