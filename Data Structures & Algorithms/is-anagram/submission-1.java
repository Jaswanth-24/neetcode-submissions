class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] smap = new int[256];
        int[] tmap = new int[256];

        for(char c : s.toCharArray()){
            smap[c]++;
        }
        for(char c : t.toCharArray()){
            tmap[c]++;
        }
        for(int i = 0; i < 256; i++){
            if(smap[i] != tmap[i]){
                return false;
            }
        }
        return true;
    }
}
