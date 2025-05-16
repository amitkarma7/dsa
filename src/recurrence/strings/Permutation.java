package recurrence.strings;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        permu("","abc");
        System.out.println(permuList("","abc"));
    }

    static  void permu(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
             String f =  p.substring(0,i);
            String s = p.substring(i, p.length());
            permu(f +ch + s,up.substring(1));
        }

    }
    static ArrayList<String> permuList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> list =new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f =  p.substring(0,i);
            String s = p.substring(i, p.length());
            list.addAll(permuList(f +ch + s,up.substring(1)));
        }
        return  list;
    }


}
