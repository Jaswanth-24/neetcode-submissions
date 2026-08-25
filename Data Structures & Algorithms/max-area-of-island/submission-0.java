class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, solve(i, j, grid));
                }
            }
        }
        return ans;
    }
    int solve(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        count += solve(i + 1, j, grid);
        count += solve(i - 1, j, grid);
        count += solve(i, j + 1, grid);
        count += solve(i, j - 1, grid);
        return count;

    }
}