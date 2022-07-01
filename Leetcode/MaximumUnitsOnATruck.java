
// https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int units = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            if (boxTypes[i][0] < truckSize) {
                units += (boxTypes[i][1] * boxTypes[i][0]);
                truckSize -= boxTypes[i][0];
            } else if (truckSize != 0) {
                units += (truckSize * boxTypes[i][1]);
                truckSize -= (truckSize);
            }
        }
        return units;
    }

    public static void main(String[] args) {
        int[][] boxTypes = { { 5, 10 },
                { 2, 5 },
                { 4, 7 },
                { 3, 9 }
        };
        int result = maximumUnits(boxTypes, 10);
        System.out.println("Result is " + result);
    }
}
