class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // since a number can be a subsequence of length 1 by itself

        for(int i = 0; i <= nums.length-1; i++){
            for(int j = 0; j <= i-1; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }
}
