// https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber {


    //Solution 1 Optimized Solution
    public static boolean isPalindrome(int x) {
        int num = 0;
        int source = x;
        while(source!=0) {
            num = num * 10;
            int k = source%10;
            num+=k;
            source/=10;
        }
        return num == x;    
    }

//     Solution 2
    // public static boolean isPalindrome(int x) {
    //    return (x+"").equals(reverseString(x+""));
    // }
    // public static String reverseString(String s) {
    //     String rStr = "";
    //     for (int i = 0; i < s.length(); i++) {
    //         rStr = s.charAt(i) + rStr;
    //     }
    //     return rStr;
    // }
    public static void main(String[] args) {
        boolean result = isPalindrome(123);
        System.out.println("Result is "+result);
    }
}
