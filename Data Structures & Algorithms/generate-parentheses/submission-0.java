class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        solve(n, 0, 0, "");
        return res;
    }
    void solve(int n, int open, int close, String s){
        if(2 * n == s.length()){
            res.add(s);
            return;
        }
        if(open < n){
            solve(n, open + 1, close, s + "(");
        }
        if(close < open){
            solve(n, open, close + 1, s + ")");
        }
    }
}
