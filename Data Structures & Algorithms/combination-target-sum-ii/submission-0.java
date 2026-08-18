class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>());
        return res;
    }
    private void solve(
        int ind, int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            solve(i + 1, candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}