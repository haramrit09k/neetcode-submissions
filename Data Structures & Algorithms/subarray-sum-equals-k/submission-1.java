class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(); // key = prefixSum, value = how many times that prefixSum has been encountered
        map.put(0, 1); // crucial line - if not added, we will miss subarrays whose sum equals k and start and beginning of array - e.g. if nums = [4,4,4], k = 4:
        //  
        for(int num: nums){
            // 1. add num to running prefixSum
            prefixSum += num;
            // 2. 
            int needed = prefixSum - k;
            count += map.getOrDefault(needed, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}