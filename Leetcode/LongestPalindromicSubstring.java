public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int[][] table = new int[s.length()][s.length()];

        int start = 0;
        int end = 0;
        int length = 1;

        // System.out.println("String length is " + s.length());
        for (int outerI = 0; outerI < s.length(); outerI++) {

            for (int j = outerI; j < s.length(); j++) {
                int i = j - outerI;

                if (i == j) {
                    table[i][j] = 1;
                } else if ((j - i) == 1 && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == 1) {
                    table[i][j] = 1;
                }
                if (table[i][j] == 1) {
                    int newLength = j - i + 1;
                    if (newLength > length) {
                        length = newLength;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {

        String s = "aababad";
        String output = longestPalindrome(s);
        System.out.println("String is " + output);
    }
}
