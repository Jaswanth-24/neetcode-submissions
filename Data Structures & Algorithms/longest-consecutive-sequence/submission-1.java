class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        for(int s : set){
            if(!set.contains(s - 1)){
                int curr = s + 1;
                int len = 1;
                while(set.contains(curr)){
                    len++;
                    curr++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
