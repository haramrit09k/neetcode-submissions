class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int best = nums[0];

        for(int i = 1; i < nums.length; i++){
            current = Math.max(nums[i], current + nums[i]); // reset current if nums[i] is greater
            best = Math.max(current, best);
        }

        return best;
    }
}
