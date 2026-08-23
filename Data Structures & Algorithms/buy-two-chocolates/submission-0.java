class Solution {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length, i = 0;
        Arrays.sort(prices);
        int chocolates = 2, spend = money;
        while(chocolates > 0 && i < n){
            if(prices[i] <= spend){
                chocolates--;
                spend -= prices[i];
            }
            i++;
        }
        return chocolates == 0 ? spend : money;
    }
}