package recurrence.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKthBit {

    public static void main(String[] args) {
        System.out.println( helper(4).charAt(11-1));
    }

    private static String helper(int n) {
        String prev = "0";
        for(int i =1; i<n;i++) {
            prev= prev + "1" + reverse(invert(prev));
        }
        System.out.println(prev);
        return prev;
    }

    private static  String reverse(String s) {
        if(s.isEmpty()) return s;
        return new StringBuilder(s).reverse().toString();

    }

    private static String invert(String inverted) {
       char[] chars = inverted.toCharArray();
       int i =0;
       while (i<chars.length) {
        chars[i] = chars[i] == '0' ? '1':'0';
           i++;
       }
        System.out.println(Arrays.toString(chars));
       return String.valueOf(chars);
    }


}
