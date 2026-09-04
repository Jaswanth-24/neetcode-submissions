class Solution {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                capture(board, r, 0);
            }
            if (board[r][n - 1] == 'O') {
                capture(board, r, n - 1);
            }
        }

        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                capture(board, 0, c);
            }
            if (board[m - 1][c] == 'O') {
                capture(board, m - 1, c);
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    private void capture(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= m ||
            c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}
