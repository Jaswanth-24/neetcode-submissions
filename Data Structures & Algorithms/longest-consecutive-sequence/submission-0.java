class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int i = 0, ans = 0;
        while(i < nums.length){
            int l = nums[i];
            int count = 0;
            while(set.contains(l)){
                count++;
                l--;
            }
            l = nums[i] + 1;
            while(set.contains(l)){
                count++;
                l++;
            }
            i++;
            ans = Math.max(count,ans);
        }
        return ans;
    }
}
