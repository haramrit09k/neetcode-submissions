class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int best = nums[0];

        int currentStart = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > current + nums[i]) {
                current = nums[i];
                currentStart = i;
            } else {
                current = current + nums[i];
            }

            if (current > best) {
                best = current;
                bestStart = currentStart;
                bestEnd = i;
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, bestStart, bestEnd + 1)));

        return best;
    }
}
