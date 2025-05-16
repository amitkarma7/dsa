package recurrence;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        isPowerOfThree(45);
        //        Main main = new Main();
//        int[] ints = new int[] { 3,6,12,5,6,11, 32};
//       int[]  newArray = main.mergesort(ints);
//        main.quicksort(ints,0,ints.length-1);
//        System.out.println(Arrays.toString(ints));
//        Arrays.sort(ints);
    }

    public static void isPowerOfThree(int n) {
        System.out.println(Math.round(Math.pow(3,calculateLogBase(n,3))) ==n);
    }

    private static double calculateLogBase(double number, double base) {
        return Math.log(number) / Math.log(base);
    }

    void fuc(int r,int c) {
        if(r==0) return;
        if(c < r) {
            System.out.print("* ");
            fuc(r,c+1);
        } else {
            System.out.println();
            fuc(r-1,0);
        }

    }

    void bubbleSort(int arr[],int r,int c) {
        if(r==0) return;
        if(c < r) {
            if(arr[c] > arr[c+1]) {
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubbleSort(arr,r,c+1);
        } else {
            bubbleSort(arr,r-1,0);
        }

    }

    void selectionSort(int arr[],int r,int c, int max) {
        if(r==0) return;
        if(c < r) {
            if(arr[c] > arr[max]) {

                selectionSort(arr,r,c+1,c);
            }else
            selectionSort(arr,r,c+1,max);
        } else {
            int temp = arr[r-1];
            arr[r-1] = arr[max];
            arr[max] = temp;
            selectionSort(arr,r-1,0,0);
        }

    }


    int[] mergesort(int[] arr) {
        if(arr.length ==1) return arr;

        int mid = arr.length/2;

        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);


    }

    private int[] merge(int[] left, int[] right) {
        int[] mix =new int[left.length+right.length];

        int i=0, j =0, k = 0;

        while (i<left.length && j < right.length) {
            if(left[i] < right[j]) {
               mix[k++] = left[i++];
            } else  {
                mix[k++] = left[j++];
            }
        }
        // if may be possible that one of the arrays is not completed
        // remaining elements will be inser into mix array
        while (i < left.length) {
            mix[k++]  = left[i++];
        }
        while (j < right.length) {
            mix[k++]  = right[j++];
        }

        return mix;
    }

    void quicksort(int[] arr ,int low,int hi) {
        if(low>=hi) {
            return;
        }
        int s = low;
        int  e =hi;
        int mid = s+ (e-s)/2;
        int pivot = arr[mid];

        while(s<=e) {

            while (arr[s] < pivot) s++;
            while (arr[e] > pivot) e--;
            if(s<=e) {
                int t = arr[s];
                arr[s] = arr[e];
                arr[e] = t;
                s++;
                e--;
            }
        }

        quicksort(arr,low,e);
        quicksort(arr, s,hi);

    }
}
