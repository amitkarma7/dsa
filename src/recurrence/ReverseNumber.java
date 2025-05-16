package recurrence;

public class ReverseNumber {

    int result = 0;
    void reverse(int n) {
        if (n == 0) {
            return ;
        }
        result  = (result*10) + n%10;
        reverse(n/10);
    }

   int rev2(int n) {
        int digit = (int)Math.log10(n)+1;

        return revhelper(n , digit) ;
    }

    private int revhelper(int n, int digit) {

        if(n%10 ==n) return n;

        return n%10 * (int)Math.pow(10,digit-1) + revhelper(n/10, digit-1);
    }

    boolean isPalindrome(int n) {
        return n == rev2(n);
    }

    int countZero(int num) {
        return countZeroHelper( num, 0);
    }

    private int countZeroHelper(int num, int count) {
            if(num == 0) return count;

            if(num %10 == 0) return countZeroHelper(num/10,count+1);

            return countZeroHelper(num/10,count);
    }

    public static void main(String[] args) {
        ReverseNumber reverseNumber =new ReverseNumber();
        ;
        System.out.println(reverseNumber.rev2(12345));
        System.out.println(reverseNumber.countZero(3201210));
    }
}
