class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        solve(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    void solve(int[] nums, List<Integer> temp, boolean[] pick){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int k = 0; k < nums.length; k++){
            if(pick[k]) continue;
            temp.add(nums[k]);
            pick[k] = true;
            solve(nums, temp, pick);
            temp.removeLast();
            pick[k] = false;
        }
    }
}
