class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] set = new int[128];
        int l = 0, res = 0;
        for(int i = 0; i < s.length(); i++){
            set[s.charAt(i)]++;
            while(set[s.charAt(i)] > 1){
                set[s.charAt(l)]--;
                l++;
            }
            res = Math.max(i - l + 1, res);
        }
        return res;
    }
}