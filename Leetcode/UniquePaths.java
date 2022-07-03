// https://leetcode.com/problems/unique-paths/
public class UniquePaths {

    // public static int uniquePaths(int m, int n) {

    // if (m == 1 || n == 1) {
    // return 1;
    // }
    // int[][] dp = new int[m][n];

    // for (int i = 1; i < m; i++) {
    // for (int j = 1; j < n; j++) {

    // dp[i - 1][j] = dp[i - 1][j] == 0 ? 1 : dp[i - 1][j];
    // dp[i][j - 1] = dp[i][j - 1] == 0 ? 1 : dp[i][j - 1];
    // dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    // }
    // }

    // for (int[] nums : dp) {
    // System.out.println(Arrays.toString(nums));
    // }

    // return dp[m - 1][n - 1];
    // }


    // Optimized of solution 1 will use less space
    public static int uniquePaths(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 0) {
                    dp[j] = 1;
                }
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // Solution 3 most optimized solution
    // public static int uniquePaths(int m, int n) {

    //     if (m == 1 || n == 1)
    //         return 1;
    //     m--;
    //     n--;
    //     if (m < n) { // Swap, so that m is the bigger number
    //         m = m + n;
    //         n = m - n;
    //         m = m - n;
    //     }
    //     long res = 1;
    //     int j = 1;
    //     for (int i = m + 1; i <= m + n; i++, j++) { // Instead of taking factorial,
    //         res *= i;
    //         res /= j;
    //     }

    //     return (int) res;
    // }

    public static void main(String[] args) {
        int result = uniquePaths(1, 2);
        System.out.println("Result is " + result);
    }
}
