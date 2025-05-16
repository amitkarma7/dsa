package trees;

import java.util.*;

public class BFSHelper {

    public List<List<Integer>> printBFS(Node node) {
        List<List<Integer>> result = new ArrayList<>();
        if(node == null) {
        return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);
                if(currentNode.left !=null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right !=null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);

        }
        return result;
    }

    // google interview
    Node findSuccessr(Node node , int key) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            if(node1.left != null) {
                queue.offer(node1.left);
            }
            if(node1.right != null) {
                queue.offer(node1.right);
            }
            if(node1.data == key) {
                break;
            }
        }
        return queue.peek();
        }

    public List<List<Integer>> levelorderZigZag(Node node) {
        List<List<Integer>> result = new ArrayList<>();
        if(node == null) {
            return result;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        boolean isReversed = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {

                if(!isReversed) {
                    Node currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.data);
                    if(currentNode.left !=null) {
                        queue.addLast(currentNode.left);
                    }
                    if(currentNode.right !=null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    Node currentNode = queue.pollLast();
                    currentLevel.add(currentNode.data);
                    if(currentNode.right !=null) {
                        queue.addFirst(currentNode.right);
                    }
                    if(currentNode.left !=null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            isReversed = !isReversed;

            result.add(currentLevel);

        }
        return result;
    }






}
