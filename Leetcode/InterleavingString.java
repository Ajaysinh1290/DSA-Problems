// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    public static String str1;
    public static String str2;
    public static String str3;

    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.isEmpty()) {
            return s2.equals(s3);
        } else if (s2.isEmpty()) {
            return s1.equals(s3);
        }

        str1 = s1;
        str2 = s2;
        str3 = s3;
        return isInterleave(0, 0, 0);
    }

    public static boolean isInterleave(int s1, int s2, int s3) {

        if (s2 >= str2.length()) {
            return true;
        }
        if (s1 >= str1.length() || s2 >= str2.length()) {
            return false;
        }
        System.out.println(
                "Comparing s1 : " + str1.substring(s1) + " s2 : " + str2.substring(s2) + " s3 : "
                        + str3.substring(s3));
        if ((compare(str1, s1, s3) || compare(str2, s2, s3))
                && (isInterleave(s1 + 1, s2, s3 + 1) || isInterleave(s1, s2 + 1, s3 + 1))) {
            return Math.abs(s2-s1)<=2;
        }
        return false;
    }

    public static boolean compare(String s, int sIndex, int index) {
        return s.charAt(sIndex) == str3.charAt(index);
    }

    public static void main(String[] args) {
        boolean result = isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println("Result is " + result);
    }
}
