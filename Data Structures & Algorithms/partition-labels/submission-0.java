class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        int i = 0, l = 0, r = 0;
        for(int j = 0; j < n; j++){
            map[s.charAt(j) - 'a'] = j;
        }
        while(i < n){
            l = i;
            r = map[s.charAt(i) - 'a'];
            while(l < r){
                if(map[s.charAt(l) - 'a'] > r){
                    r = map[s.charAt(l) - 'a'];
                }
                l++;
            }
            ans.add(r - i + 1);
            i = r + 1;
        }
        return ans;
    }
}