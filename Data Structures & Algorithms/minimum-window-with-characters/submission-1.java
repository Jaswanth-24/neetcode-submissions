class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, sInd = -1, count = 0, minLen = Integer.MAX_VALUE;
        int[] map = new int[256];
        for(char c : t.toCharArray()){
            map[c]++;
        }
        while(r < s.length()){
            if(map[s.charAt(r)] > 0){
                count++;
            }
            map[s.charAt(r)]--;
            while(count == t.length()){
                if(minLen > r - l + 1){
                    minLen = r - l + 1;
                    sInd = l; 
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return sInd == -1 ? "" : s.substring(sInd, sInd + minLen);
    }
}
