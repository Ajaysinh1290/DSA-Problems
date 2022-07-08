// https://leetcode.com/problems/where-will-the-ball-fall/

import java.util.Arrays;

public class WhereWillTheBallFall {

    // Iterative solution
    // public static int[] findBall(int[][] grid) {
    //     int ball[] = new int[grid[0].length];

    //     for (int i = 0; i < ball.length; i++) {
    //         ball[i] = -1;
    //     }
    //     if (grid.length == 1 && grid[0].length == 1) {
    //         return ball;
    //     }
    //     for (int i = 0; i < grid[0].length; i++) {
    //         int x = 0;
    //         int y = i;

    //         while (x < grid.length) {

    //             if (y == 0 && grid[x][y] == -1 || y == (grid[0].length - 1) && grid[x][y] == 1) {
    //                 ball[i] = -1;
    //                 break;
    //             } else if (grid[x][y] == 1 && grid[x][y + 1] == 1) {
    //                 ball[i] = (y);
    //                 x++;
    //                 y++;

    //             } else if (grid[x][y] == -1 && grid[x][y - 1] == -1) {
    //                 ball[i] = (y);
    //                 y--;
    //                 x++;
    //             } else {

    //                 ball[i] = -1;
    //                 break;
    //             }
    //             if (x >= grid.length) {
    //                 ball[i] = y;
    //                 break;
    //             }
    //         }

    //     }

    //     return ball;
    // }

    // Recursion
    public static int[] findBall(int[][] grid) {

        int[] balls = new int[grid.length];

        for (int i = 0; i < balls.length; i++) {
            balls[i] = -1;
        }
        for (int i = 0; i < grid.length; i++) {
            balls[i] = findBall(0, i, grid);
        }
        return balls;
    }

    public static int findBall(int x, int y, int[][] grid) {
        if (y >= grid[0].length) {
            return -1;
        }
        if (x >= grid.length) {
            return y;
        }
        if (grid[x][y] == 1) {
            if (y != grid[0].length - 1 && grid[x][y + 1] == 1) {
                return findBall(x + 1, y + 1, grid);
            }
        } else if (grid[x][y] == -1) {
            if (y != 0 && grid[x][y - 1] == -1) {
                return findBall(x + 1, y - 1, grid);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = { { 1, 1, 1, -1, -1 }, { 1, 1, 1, -1, -1 }, { -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1 },
                { -1, -1, -1, -1, -1 } };
        int[] result = findBall(grid);
        System.out.println("Result is " + Arrays.toString(result));
    }
}
