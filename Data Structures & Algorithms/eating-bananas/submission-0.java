class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int pile : piles)   high = Math.max(high, pile);
        int low = 1, res = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canKoko(piles, h, mid)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    boolean canKoko(int[] piles, int h, int k){
        int sum = 0;
        for(int pile : piles){
            sum += Math.ceil((double)pile / k);
        }
        return sum <= h;
    }
}
