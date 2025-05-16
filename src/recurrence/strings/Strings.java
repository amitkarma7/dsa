package recurrence.strings;

public class Strings {

    public static void main(String[] args) {
        skipChar("","baccad");
    }

    static  void skipChar(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a') {
            skipChar(p, up.substring(1));
        } else {
            skipChar(p+ch,up.substring(1));
        }
    }
}
