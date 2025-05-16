package recurrence.strings;

import java.util.*;
import java.util.stream.Collectors;

public class CominationSum {

    public static void main(String[] args) {
        Set<List<Integer>> list = new HashSet<>();

        List<List<Integer>> fl = list.stream().sorted().collect(Collectors.toCollection(() -> new ArrayList<>()));
        for(List<Integer> inner : fl){
            Collections.sort(inner);
        }
    }

    void comibination(int[] arr, int target ,int sum , int index) {
        if(index == arr.length) {
            return;
        }
        if(sum == target) System.out.println("found  ");;

        for(int i=1;i<7;i++) {

        }
    }

    static  void dice(String p , int target) {

        if(target ==0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i<=target; i++) {
            dice(p+i,target-i);
        }




    }
}
