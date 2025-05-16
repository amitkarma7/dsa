package trees;

public class SegmentTree {

    Node root;

    public SegmentTree(int arr[]) {

        this.root = consructTree(arr,0,arr.length-1);
    }

    private Node consructTree(int[] arr, int startIndex, int endIndex) {

        if(startIndex ==endIndex) {
            Node node = new Node(startIndex,endIndex);
            node.data = arr[startIndex];
            return node;
        }

        Node node = new Node(startIndex,endIndex);
        int mid = (startIndex+endIndex) /2;
        node.left = consructTree(arr,startIndex,mid);
        node.right = consructTree(arr,mid+1,endIndex);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public void display() {
        display(root);
    }

    private void display(Node root) {
        String str ="";
        if(null == root) {
            return;
        }
        if(root.left != null) {
            str+="Interval=[" + root.left.startInterval + ", " + root.left.endInterval + "] and data : " + root.left.data +" >>>> ";
        } else {
            str+= "No Left child";
        }
        if(root !=null) {
            str+= "Interval=[" + root.startInterval + ", " + root.endInterval + "] and data : " + root.data +" >>>> ";
        }
        if(root.right != null) {
            str+="Interval=[" + root.right.startInterval + ", " + root.right.endInterval + "] and data : " + root.left.data +" >>>> ";
        } else {
            str+= "No Right child";
        }
        System.out.println(str);

        if(root.left != null) {
            display(root.left);
        }
        if(root.right != null) {
            display(root.right);
        }

    }


    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if(node ==null) {
            return 0;
        }
        if (node.startInterval >= qsi && node.endInterval <= qsi) {
            // node is completely lying inside query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // completely outside

            return 0;
        } else {
            // overlaping
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }

    }

    public void update(int index, int value) {
        this.root.data = update(root,index,value);
    }

    private int update(Node node, int index, int value) {
        if(index >= node.startInterval && index <= node.endInterval) {
            if(index == node.startInterval && index == node.endInterval) {
                node.data =value;
                return node.data;
            } else {
                int leftAns = update(node.left,index,value);
                int rightAns = update(node.right,index,value);
                node.data = leftAns + rightAns;
                return node.data;
            }

        } else {
            return node.data;
        }
    }


}
