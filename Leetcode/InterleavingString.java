import java.util.HashMap;

// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] map = new int[s1.length()][s2.length()];

        return isInterleave(s1, 0, s2, 0, s3, 0,map);
    }

    public static boolean isInterleave(String str1, int s1, String str2, int s2, String str3, int s3,int[][] map) {

        if (s1 == str1.length()) {
            return str2.substring(s2).equals(str3.substring(s3));
        }

        if (s2 == str2.length()) {
            return str1.substring(s1).equals(str3.substring(s3));
        }

        if(map[s1][s2]>=1) {
            return map[s1][s2]==2;
        }
  
        boolean result = false;
        if (str1.charAt(s1) == str3.charAt(s3) && isInterleave(str1, s1 + 1, str2, s2, str3, s3 + 1,map)
                || str2.charAt(s2) == str3.charAt(s3)
                        && isInterleave(str1, s1, str2, s2 + 1, str3, s3 + 1,map)) {
            result = true;
        }
        map[s1][s2] = result?2:1;
        return result;
    }


    public static void main(String[] args) {
        boolean result = isInterleave("a", "b", "ab");
        System.out.println("Result is " + result);
    }
}
