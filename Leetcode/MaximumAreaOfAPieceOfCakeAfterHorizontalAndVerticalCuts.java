// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long dp[] = new long[2];
        dp[0] = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length-1]);
        dp[1] = Math.max(verticalCuts[0],w-verticalCuts[verticalCuts.length-1]);
        for (int i = 0; i < horizontalCuts.length-1||i<verticalCuts.length-1; i++) {
            if(i<horizontalCuts.length-1) {
                dp[0] = Math.max(dp[0], horizontalCuts[i + 1] - horizontalCuts[i]);
            }
            if(i<verticalCuts.length-1) {
                dp[1] = Math.max(dp[1], verticalCuts[i + 1]  - verticalCuts[i]);
            }
        }
        return (int) ((long) dp[0] * dp[1] % 1000000007);
    }
    // public static int maxArea(int h, int w, int[] hc, int[] vc) {
    // Arrays.sort(hc);
    // Arrays.sort(vc);
    // int maxh = Math.max(hc[0], h - hc[hc.length-1]),
    // maxv = Math.max(vc[0], w - vc[vc.length-1]);
    // for (int i = 1; i < hc.length; i++)
    // maxh = Math.max(maxh, hc[i] - hc[i-1]);
    // for (int i = 1; i < vc.length; i++)
    // maxv = Math.max(maxv, vc[i] - vc[i-1]);
    // return (int)((long)maxh * maxv % 1000000007);
    // }

    // private static long getMaxDist(int end, int[] cuts) {
    // Arrays.sort(cuts);
    // long res = 0, from = 0;
    // for (int c : cuts) {
    // res = Math.max(res, c - from);
    // from = c;
    // }
    // return Math.max(res, end - from);
    // }

    public static void main(String[] args) {
        int result = maxArea(5, 4, new int[] {1,2,4 }, new int[] { 1,3 });
        System.out.println("Result is " + result);
    }
}
