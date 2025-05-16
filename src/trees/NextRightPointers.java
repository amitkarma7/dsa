package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextRightPointers {

    public Node connect(Node root) {
        if(root ==null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> currentLevel = new ArrayList<>(levelSize);
            Node currentNode = queue.poll();
            for(int i=0; i<levelSize-1;i++ ) {
                Node nextPoll = queue.poll();
                currentLevel.add(nextPoll);

                currentNode.next = nextPoll ;
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                currentNode = nextPoll;

            };

        }

        return root;
    }
}
