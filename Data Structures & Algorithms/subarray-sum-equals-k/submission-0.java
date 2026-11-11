class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(); // key = prefixSum, value = how many times that prefixSum has been encountered
        map.put(0, 1);
        for(int num: nums){
            prefixSum += num;
            int currSum = prefixSum - k;
            count += map.getOrDefault(currSum, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}