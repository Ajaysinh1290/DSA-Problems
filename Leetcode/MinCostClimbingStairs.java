// https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        

        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<cost.length; i++) {
            if((dp[(i-2)%2]+cost[i])<dp[(i-1)%2]+cost[i]) {
                dp[i%2] = dp[(i-2)%2]+cost[i];
            }else{
                dp[i%2] = dp[(i-1)%2]+cost[i];
            }
        }

        return dp[0]<dp[1]?dp[0]:dp[1];
    }
   
    public static void main(String[] args) {
        int[] array = {1,100,1,1,1,100,1,1,100,1};
        int result =  minCostClimbingStairs(array);
        System.out.println("Result is "+result);
    }
}
