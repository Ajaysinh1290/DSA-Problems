// https://leetcode.com/problems/last-stone-weight/

import java.util.Arrays;
public class LastStoneWeight {

    

    public static void sortArray(int[] stones,int length) {

        for(int i = length-1; i>0; i--) {
            if(stones[i-1]>stones[i]) {
                int temp = stones[i-1];
                stones[i-1] = stones[i];
                stones[i] = temp;
            }else {
                break;
            }
        }
    }
    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        int n = stones.length;

        while (n >= 2) {
            int y = stones[--n];
            int x = stones[--n];

            if (x != y) {
                stones[n] = y-x;
                sortArray(stones, ++n);
                
            }
        }
        return n == 1 ? stones[n-1] : 0;
    }

    // public static int lastStoneWeight(int[] stones) {
    //     PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    //     for (int stone : stones) {
    //         queue.add(stone);
    //     }
    //     while (queue.size() > 1) {
    //         int big = queue.poll();
    //         int small = queue.poll();
    //         if (big != small) {
    //             queue.add(big - small);
    //         }
    //     }
    //     if (queue.size() == 0) {
    //         return 0;
    //     } else {
    //         return queue.poll();
    //     }
    // }
    public static void main(String[] args) {
        int stones[] = {2,7,4,1,8,1};
        int result = lastStoneWeight(stones);
        System.out.println("Result is " + result);
    }
}
