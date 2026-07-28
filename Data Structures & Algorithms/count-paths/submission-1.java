class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)    continue;
                int ans = 0;
                if(i > 0){
                    ans += dp[i - 1][j];
                }
                if(j > 0){
                    ans += dp[i][j - 1];
                }
                dp[i][j] = ans;
            }
        }
        return dp[m - 1][n - 1];
    }
    int solve(int i, int j, int m, int n, int[][] dp){
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        if(i < 0 || j < 0 || i > m - 1 || j > n - 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = solve(i, j + 1, m, n, dp);
        int down = solve(i + 1, j, m, n, dp);
        return dp[i][j] = right + down; 
    }
}
