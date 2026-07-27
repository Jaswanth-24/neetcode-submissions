class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            map[c - 'a']++;
        }
        int r = 0, l = 0;
        while(r < s2.length()){
            freq[s2.charAt(r) - 'a']++;
            while((r - l + 1) >= s1.length()){
                if(Arrays.equals(map,freq)){
                    return true;
                }
                freq[s2.charAt(l) - 'a']--;
                l++;
            }
            
            r++;
        }
        return false;
    }
}
