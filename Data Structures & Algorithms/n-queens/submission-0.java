class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] arr = new char[n][n];
        for(char[] c : arr){
            Arrays.fill(c, '.');
        }
        solve(0, arr);
        return res;
    }
    void solve(int i, char[][] arr){
        if(i == arr.length){
            res.add(new ArrayList<>(helper(arr)));
            return;
        }
        for(int j = 0; j < arr.length; j++){
            if(isSafe(i, j, arr)){
                arr[i][j] = 'Q';
                solve(i + 1, arr);
                arr[i][j] = '.';
            }
        }
    }
    boolean isSafe(int row, int col, char[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    List<String> helper(char[][] arr){
        List<String> list = new ArrayList<>();
        for (char[] c : arr) {
            list.add(new String(c));
        }
        return list;
    }
}

