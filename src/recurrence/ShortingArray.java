package recurrence;

public class ShortingArray {

    public static void main(String[] args) {

    }


    int findIndex(int[] arr , int target, int index ) {

        if(index == arr.length-1) return -1;

        if(arr[index] == target) return index;

        return findIndex(arr,target,index+1);
    }


}
