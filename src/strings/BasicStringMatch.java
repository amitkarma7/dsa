package strings;

public class BasicStringMatch {

    public static void main(String[] args) {
        String text = "abcdefg";
        String pattern = "def";
        search(text,pattern);
    }

    private static void search(String text, String pattern) {

        for (int i = 0; i < text.length()-pattern.length(); i++) {
            String substring  = text.substring(i,i+pattern.length());
            if( substring.equals(pattern)) {
                System.out.println("found at index : " + i);
            }
        }

    }
}
