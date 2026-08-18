class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        solve(0, nums, new ArrayList<>());
        return res;
    }
    void solve(int i, int[] nums,List<Integer> temp){
        if(i == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i + 1, nums, temp);
        temp.remove(temp.size() - 1);
        solve(i + 1, nums, temp);
    }
}
