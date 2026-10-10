class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            int fresh = nums[i];
            int extendMax = currentMax * nums[i];
            int extendMin = currentMin * nums[i];

            int newMax = Math.max(fresh, Math.max(extendMax, extendMin));
            int newMin = Math.min(fresh, Math.min(extendMax, extendMin));

            currentMax = newMax;
            currentMin = newMin;

            globalMax = Math.max(currentMax, globalMax); 
        }

        return globalMax;
    }
}
