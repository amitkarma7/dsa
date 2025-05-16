package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap<T extends Comparable<T>> {
    private List<T> list =new ArrayList<T>();


    void  insert(T value) {
        list.add(value);
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if(index == 0 ) return;


        int parent  = parent(index);
        if(list.get(index).compareTo(list.get(parent)) <0) {
            swap(index,parent);
            upheap(parent); // recall to arrange the parent
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty())  {
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()) {
            list.set(0,last);
            downHeap(0);
        }

        return temp;

    }

    private void downHeap(int index) {

        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min  = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min  = right;
        }

        if(min != index) {
            swap(min, index);
            downHeap(min);
        }



    }

    private  int parent(int index) {
        return (index-1)/2;
    }

    private  int left(int index) {
        return index*2 +1;
    }
    private  int right(int index) {
        return index*2 +2;
    }


    private  void swap(int i, int j) {
       T value = list.get(i);
       list.set(i , list.get(j));
        list.set(j , value);
    }

    ArrayList<T> heapsort() throws Exception{

        ArrayList<T> data =new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }


    List<T> heapUnSorted(T[] arr) {
        list = Arrays.asList(arr);
        int parent = parent(list.size()-1);
        for (int i = parent; i>-1;i--) {
            downHeap(i);
        }
        return list;
    }

}
