class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(); // key = prefixSum, value = how many times that prefixSum has been encountered
        map.put(0, 1); // <- crucial line - if not added, we will miss subarrays whose sum equals k and start and beginning of array 
        // e.g. if nums = [4,4,4], k = 4:
        // without map.put(0,1) -> we miss the 4 at the start of the array and return count as 2 instead of 3 -> prefixSum = 4, diff = prefixSum - k = 0 -> look up 0 in map - not found
        // with map.put(0,1) -> we make sure to include the 4 at the start of the array and return count as 3 correctly -> map = {0: 1}, prefixSum = 4, diff = 0 -> Look up 0 → count is 1
        for(int num: nums){
            // 1. add num to running prefixSum
            prefixSum += num;

            // 2. check if we saw a prefix sum that, when removed, leaves sum k
            // we are relying on the formula - 
            // if P[i] = sum of elements from idx 0 to i, then sum of subarray from j+1 to i is -
            // P[i] - P[j]
            // we want that subarray sum to be equal to k i.e. P[i] - P[j] = k
            // hence, we can rearrange and get P[j] = P[i] - k
            // in the code, prefixSum = P[i], and needed = P[j]
            int needed = prefixSum - k;
            count += map.getOrDefault(needed, 0);

            // 3. add current prefixSum for future subarrays
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}