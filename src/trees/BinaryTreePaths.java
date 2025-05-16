package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BinaryTreePaths {

    public static void main(String[] args) {
        List<Integer> arr = List.of(1,7,0,7,-8);

        TreeNode root =new TreeNode(arr.get(0));
        root.left = new TreeNode(arr.get(1));
        root.right = new TreeNode(arr.get(2));
        root.left.left = new TreeNode(arr.get(3));
        root.left.right = new TreeNode(arr.get(4));

//        System.out.println(binaryTreePaths(root));
        System.out.println(maxLevelSum(root));
    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list =  new ArrayList<>();
        new ArrayList<String>(List.of(String.valueOf(2)));

        binaryTreePaths(root , list,root.val + "->");
        return list;
    }

    private static void binaryTreePaths(TreeNode root , List<String> list ,String str) {
        if(root == null || root.left ==null && root.right == null ) {
            str=str.substring(0,str.length()-2);
            list.add(str);
            return ;
        }

        if(root.left !=null) {
            binaryTreePaths(root.left, list , str+ root.left.val +"->" );
        }
        if(root.right !=null) {
            binaryTreePaths(root.right, list,  str+ root.right.val +"->");
        }
    }


    public static int maxLevelSum(TreeNode root) {

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxValue = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for(int i =0;i<size;i++) {
                TreeNode curr = queue.poll();
                sum+= curr.val;
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            maxValue = Math.max(sum,maxValue);
        }

        return maxValue;

    }


}
