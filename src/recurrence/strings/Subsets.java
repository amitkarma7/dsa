package recurrence.strings;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

//    subsets for array and subseq for Strings

    public static void main(String[] args) {
        subseq("","abc");
        System.out.println(subseqList("","abc"));
        System.out.println(subseq(new int[] { 1,2,3}));
    }

    static void subseq(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p,up.substring(1));
        subseq(p+ch,up.substring(1));
    }
    static ArrayList<String> subseqList(String p, String up) {
        ArrayList<String> strings =new ArrayList<>();
        if(up.isEmpty()) {
            if(!p.isEmpty()) {
                strings.add(p);
            }
            return strings;
        }
        char ch = up.charAt(0);
        ArrayList<String> left =   subseqList(p+ch,up.substring(1));
        ArrayList<String> right = subseqList(p,up.substring(1));
        strings.addAll(left);
        strings.addAll(right);
        return strings;

    }

    // via itrator

    static List<List<Integer>> subseq(int[] arr) {
        List<List<Integer>> outer =new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i <n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);

            }
        }
        return outer;
    }
}
