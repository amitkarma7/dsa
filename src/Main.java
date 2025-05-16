import trees.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BinarySearchTree avlTree =new BinarySearchTree();
                int[] arr = {236,104,701,Integer.MAX_VALUE,227,Integer.MAX_VALUE,911};
//
        for (int i =0;i < arr.length;i++) {
            avlTree.insert(arr[i]);

        }
//        System.out.println("stack  ---------> +" + stack);
//        System.out.println(); // always log(n)  log(1000) -> 3
       avlTree.display("inorder");
//
//
//        stack.pop();



//        SegmentTree tree = new SegmentTree(arr);
//         tree.display();

//        tree.update(3, 14);
//        tree.display();

//        System.out.println(tree.query(1, 6));
        BinarySearchTree binarySearchTree =new BinarySearchTree();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7);
        for (int i = 0; i < list.size(); i++) {
            binarySearchTree.insert(list.get(i));
        }

        binarySearchTree.display("inorder");

                NextRightPointers nextRightPointers =new NextRightPointers();
        Node root = nextRightPointers.connect(binarySearchTree.getRoot());


    }

} 