package heap;

import java.util.List;

public class HeapMain {
    public static void main(String[] args) throws Exception {
        Heap<Integer> integerHeap =new Heap<>();

        integerHeap.insert(34);
        integerHeap.insert(45);
        integerHeap.insert(22);
        integerHeap.insert(89);
        integerHeap.insert(76);
        integerHeap.insert(19);

//        System.out.println(integerHeap.remove());
//        System.out.println(integerHeap.remove());
//        System.out.println(integerHeap.remove());

        System.out.println(integerHeap.heapsort());
        List<Integer> list =  integerHeap.heapUnSorted(new Integer[] {1,3,45,5,6,6,4,4});
        System.out.println(list);


    }
}
