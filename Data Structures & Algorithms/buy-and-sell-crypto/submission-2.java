class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1; // i = buying point, j = selling point
        int maxProfit = 0;
        while(j < prices.length){
            int profit = prices[j] - prices[i];
            // THE BELOW IS THE MAIN CONDITION TO REMEMBER FOR SLIDING WINDOW APPROACH
            // if profit < 0 - that means there is a better buying point
            if(profit < 0){
                i = j;
            }
            maxProfit = Math.max(profit, maxProfit);
            j++; // always keep incrementing j
        }
        return maxProfit;
    }
}
