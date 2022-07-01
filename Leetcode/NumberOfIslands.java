public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int count = 0;
        for(int i= 0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                if(grid[i][j]=='1') {
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }   

    public static void markIsland(char[][] grid, int sr,int sc) {
        grid[sr][sc] = '0';
        if ((sr - 1) != -1  && grid[sr-1][sc]=='1') {
            markIsland(grid, sr - 1, sc);
        }
        if ((sr + 1) < grid.length && grid[sr + 1][sc] == '1') {
            markIsland(grid, sr + 1, sc);
        }
        if ((sc - 1) != -1 && grid[sr][sc - 1] == '1') {
            markIsland(grid, sr, sc - 1);
        }
        if ((sc + 1) < grid[sr].length && grid[sr][sc + 1] == '1') {
            markIsland(grid, sr, sc + 1);
        }
    }



    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '1' }
        };
        int result = numIslands(grid);
        System.out.println("Result is " + result);
    }
}
