package trees;


public class Node{
    int data;
    int ht;
    Node left, right;
    Node next;

    int startInterval;
    int endInterval;


    public Node(Integer data) {
        this.data = data;
    }

    public Node(int startInterval, int endInterval) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }
}

