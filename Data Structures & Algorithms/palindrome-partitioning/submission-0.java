class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        solve(0, s, new ArrayList<>());
        return res;
    }
    void solve(int i, String s, List<String> list){
        if(i == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(i, j, s)){
                list.add(s.substring(i, j + 1));
                solve(j + 1, s, list);
                list.removeLast();
            }
        }
    }
    boolean isPalindrome(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
