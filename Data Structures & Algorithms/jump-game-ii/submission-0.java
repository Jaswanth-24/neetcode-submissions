class Solution {
    public int jump(int[] nums) {
        int far = 0, jumps = 0, r = 0;
        for(int l = 0; l < nums.length - 1; l++){
            far = Math.max(far, l + nums[l]);
            if(r == l){
                jumps++;
                r = far;
            }
        }
        return jumps;
    }
}
