// https://leetcode.com/problems/the-latest-time-to-catch-a-bus/

import java.util.Arrays;
import java.util.HashSet;

public class TheLatestTimeToCatchABus {
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        if (buses.length == 1 && passengers[0] < buses[0]) {
            return buses[0];
        }
        System.out.println(" Buses " + Arrays.toString(buses));
        System.out.println("Passengers " + Arrays.toString(passengers));
        HashSet<Integer> set = new HashSet();

        int pIndex = 0;
        for (int i = 0; i < buses.length; i++) {
            for (int j = 0; j < capacity; j++) {
                if (i == buses.length - 1 && j == capacity - 1 || pIndex == passengers.length - 1) {
                    int iIndex = pIndex == passengers.length || passengers[pIndex] > buses[i] ? buses[i]
                            : passengers[pIndex] - 1;
                    System.out.println("I index is " + iIndex);
                    for (int k = iIndex; k >= 0; k--) {
                        if (!set.contains(k)) {
                            return k;
                        }
                    }
                } else if (buses[i] >= passengers[pIndex]) {
                    set.add(passengers[pIndex]);
                    pIndex++;
                }
            }
        }
        return passengers[pIndex];
    }

    // Accepted solution
    // public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
    //     Arrays.sort(buses);
    //     Arrays.sort(passengers);
        
    //     int bn = buses.length;
    //     int pn = passengers.length;
        
    //     if (passengers[0]>buses[bn-1]) {
    //         return buses[bn-1];
    //     }
        
    //     int p, b, c;
    //     for(p=0, b=0, c = 0; p<pn && b<bn;) {
    //         if (passengers[p]>buses[b]) {
    //             b += 1;
    //             c = 0;
    //         } else {
    //             p += 1;
    //             c += 1;
    //             if (c == capacity) {
    //                 b += 1;
    //                 if (b != bn) {
    //                     c = 0;   
    //                 }
    //             }
    //         }
    //     }
    //     // System.out.println(c+" "+p);
    //     if (c != capacity && passengers[p-1]!=buses[bn-1]) {
    //         return buses[bn-1];
    //     }
        
    //     p -= 1;
    //     int ans = passengers[p];
        
    //     while(p>=0 && ans == passengers[p]) {
    //         ans -= 1;
    //         p -= 1;
    //     }
    //     return ans;
    // }
    public static void main(String[] args) {
        int[] buses = { 14, 10, 4, 5, 7, 2, 11, 19, 16, 9 };

        int[] passengers = { 3, 39, 45, 30, 40, 50, 13, 15, 34, 5 };
        int result = latestTimeCatchTheBus(buses, passengers, 3);
        System.out.println("Result is " + result);
    }
}
