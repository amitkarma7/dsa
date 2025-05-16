package trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueGenerateTrees {
    public static void main(String[] args) {

//        TreeNode node = generateSkerwedTree(3);
        new ArrayList<>().addAll(List.of());
//        displayInOrder(node, "");
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list =  new ArrayList<>();
        return new ArrayList<>(list);
    }

//    List<TreeNode> genrate(List<TreeNode> list, int n) {
//
//
//    }

   static List<TreeNode> generateSkerwedTree(List<TreeNode> list, int n) {
       int i = 1;
       TreeNode root= new TreeNode(i++);
       TreeNode temp = root;
       list.add(temp);
        while (i<=n) {
            temp.right =new TreeNode(i);
            list.add(temp.right);
            temp = temp.right;
            i++;
        }
        return list;
    }

    private static void displayInOrder(TreeNode node, String details) {
        if (node == null) return;
        System.out.print(node.val + " ");
        displayInOrder(node.left, "Left child of " + node.val + " : ");
        displayInOrder(node.right, "Right child of " + node.val + " : ");
    }



}
