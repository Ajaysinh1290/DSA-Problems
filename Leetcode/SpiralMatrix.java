// https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;


        /*
         * 0 = left to right ,
         * 1 = top to bottom,
         * 2 = right to left ,
         * 3 = bottom to top
         */

        int dir = 0;
        List<Integer> list = new ArrayList<Integer>();

        int index = 0;
        while (list.size() < (matrix[0].length * matrix.length)) {
            if (dir == 0) {
                // left to right so index will increase in this case
                list.add(matrix[top][index]);

                // when index will equals right side then we will change direction to 1
                if (index == right) {
                    dir = 1;
                    top++;
                    // now index will start with top
                    index = top;
                } else {
                    index++;
                }
            } else if (dir == 1) {
                // top to bottom so index will increase in this case
                list.add(matrix[index][right]);

                // when index will equals bottom side then we will change direction to 2
                if (index == (bottom)) {
                    dir = 2;
                    right--;
                    // now index will start from right
                    index = right;
                } else {
                    index++;
                }
            } else if (dir == 2) {
                // right to left so index will decrease in this case
                list.add(matrix[bottom][index]);

                // when index will equals left side then we will change direction to 3
                if (index == left) {
                    dir = 3;
                    bottom--;
                    // now index will start from bottom
                    index = bottom;
                } else {
                    index--;
                }
            } else if (dir == 3) {
                // bottom to top so index will decrease in this case
                list.add(matrix[index][left]);

                // when index will equals top side then we will change direction to again 1
                if (index == top) {
                    dir = 0;
                    left++;
                    // And again now index will start from left
                    index = left;
                } else {
                    index--;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
        List<Integer> result = spiralOrder(matrix);
        System.out.println("Result is " + Arrays.toString(result.toArray()));
    }
}
