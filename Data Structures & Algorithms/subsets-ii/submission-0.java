class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        solve(0, nums, new ArrayList<>());
        return res;
    }
    void solve(int i, int[] nums, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int ind = i; ind < nums.length; ind++){
            if(ind > i && nums[ind] == nums[ind - 1]){
                continue;
            }
            list.add(nums[ind]);
            solve(ind + 1, nums, list);
            list.removeLast();
        }
    }
}
