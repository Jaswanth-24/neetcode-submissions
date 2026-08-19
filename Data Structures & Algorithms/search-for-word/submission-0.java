class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(i, j, 0, board, word, vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean solve(int i, int j, int k, char[][] board, String word, boolean[][] vis){
        if(k == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != word.charAt(k)){
            return false;
        }
        vis[i][j] = true;
        if(solve(i + 1, j, k + 1, board, word, vis) ||
                solve(i - 1, j, k + 1, board, word, vis) ||
                solve(i, j + 1, k + 1, board, word, vis) ||
                solve(i, j - 1, k + 1, board, word, vis)){
                    return true;
                }
        vis[i][j] = false;
        return false;
    }
}
