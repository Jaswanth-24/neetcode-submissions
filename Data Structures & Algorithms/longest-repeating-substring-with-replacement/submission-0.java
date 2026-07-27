class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int l = 0, maxFrq = 0, ans = 0;

        for (int r = 0; r < s.length(); r++){
            int i = s.charAt(r) - 'A';
            map[i]++;
            maxFrq = Math.max(map[i], maxFrq);

            while((r - l + 1) - maxFrq > k){
                map[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(r - l + 1, ans);
        } 
        return ans;
    }
}
