class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int far = 0, jumps = 0, r = 0;
        for(int l = 0; l < n - 1; l++){
            far = Math.max(far, l + nums[l]);
            if(r == l){
                jumps++;
                r = far;
            }
        }
        return jumps;
    }
}
