class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int res = 0;
        while(l < r){
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if(leftMax < rightMax){
                res += leftMax - height[l];
                l++;
            }
            else{
                 res += rightMax - height[r];
                r--;
            }
        }
        return res;
    }
}
