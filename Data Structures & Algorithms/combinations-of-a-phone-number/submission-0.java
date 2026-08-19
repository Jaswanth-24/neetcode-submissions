class Solution {
    HashMap<Integer, String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        solve(0, digits, "");
        return res;
    }
    void solve(int i, String digits, String curr){
        if(i == digits.length()){
            res.add(curr);
            return;
        }
        String s = map.get(digits.charAt(i) - '0');

        for(int j = 0; j < s.length(); j++){
            solve(i + 1, digits, curr + s.charAt(j));
        }
    }
}
