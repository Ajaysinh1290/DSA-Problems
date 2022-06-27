// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyandSellStock {

    // Solution 1 O(n^2)
    // public static int maxProfit(int[] prices) {

    // int profit = 0;

    // for (int i = 0; i < prices.length - 1; i++) {
    // for (int j = i + 1; j < prices.length; j++) {
    // int newProfit = prices[j] - prices[i];
    // if (newProfit > profit) {
    // profit = newProfit;
    // }
    // }

    // }
    // return profit;
    // }

    // Solution 2 Optimized Solution O(n)
    public static int maxProfit(int[] prices) {

        int start = 0;
        int end = 1;
        int profit = 0;

        while (end < prices.length) {
            if (prices[end] < prices[start]) {
                start = end;
            } else if (prices[end] - prices[start] > profit) {
                profit = prices[end] - prices[start];
            }
            end++;
        }
        return profit;

    }

    public static void main(String[] args) {
        int result = maxProfit(new int[] { 2, 4, 1 });
        System.out.println("Result is " + result);
    }
}
