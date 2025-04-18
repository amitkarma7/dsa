package trees;

public class TreeImplementation {

   public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }



    Node insertion(Node root, int  value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }

        if(value > root.data) {
            root.right = insertion(root.right,value);
        } else {
            root.left = insertion(root.left,value);
        }
        return root;
    }

    void preOrder(Node root) {
        if(root == null)  return;
        System.out.print(root.data + " " );
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        TreeImplementation treeImplementation = new TreeImplementation();
        Node root = new Node(12);

        treeImplementation.insertion(root ,15);

        treeImplementation.insertion(root ,4);

        treeImplementation.insertion(root ,10);
        treeImplementation.insertion(root ,1);
        treeImplementation.insertion(root ,5);
        treeImplementation.insertion(root ,45);

        treeImplementation.preOrder(root);
    }

}
