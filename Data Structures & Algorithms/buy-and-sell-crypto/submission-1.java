class Solution {
    public int maxProfit(int[] prices) {
        // brute force
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i+1; j<prices.length; j++){
                int profit_i_j = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit_i_j);
            }
        }

        return maxProfit;
    }
}
