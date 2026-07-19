class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while(l < r){
            int currSum = numbers[l] + numbers[r];
            if(currSum == target){
                return new int[]{l + 1, r + 1};
            }
            else if(currSum < target){
                l++;
            }
            else{
                r--;
            }
        }
        return new int[]{0,0};
    }
}
