public class ClimbingStairs {
    
    public static int climbStairs(int n) {
        if(n<=3) return 3;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<= n; i++ ) {
            dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2];
        }
        return dp[0] + dp[1];
    }
    public static void main(String[] args) {
        int result = climbStairs(6);
        System.out.println("Result is "+result);
    }
}
