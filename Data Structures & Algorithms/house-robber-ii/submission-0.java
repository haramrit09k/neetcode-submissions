class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int caseA = robLinear(nums, 0, nums.length-2);
        int caseB = robLinear(nums, 1, nums.length-1);

        return Math.max(caseA, caseB);
    }

    private int robLinear(int[] nums, int start, int end){
        int[] dp = new int[nums.length+1];

        if(start == end){
            return nums[start];
        }

        if(start+1 == end){
            return Math.max(nums[start], nums[start+1]);
        }

        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i <= end; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[end];
    }
}
