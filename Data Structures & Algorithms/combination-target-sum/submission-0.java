class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        solve(0, nums, target, new ArrayList<>());
        return res;
    }
    void solve(int i, int[] nums, int target, List<Integer> temp){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i == nums.length){
            return;
        }
        
        if(nums[i] <= target){
            temp.add(nums[i]);
            solve(i, nums, target - nums[i], temp);
            temp.remove(temp.size() - 1);
        }
        solve(i + 1, nums, target, temp);
    }
}
