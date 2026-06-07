class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numSet = new TreeSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int[] numSetArr = numSet.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(numSetArr));
        int[] diffNums = new int[numSetArr.length];
        for(int i = 0; i < numSetArr.length - 1; i++){
            diffNums[i] = numSetArr[i+1] - numSetArr[i];
        }

        System.out.println(Arrays.toString(diffNums));

        int count = 1, maxCount = 1;
        for(int j = 0; j<diffNums.length; j++){
            if(diffNums[j] != 1){
                count = 1;
                continue;
            }
            count++;
            if(count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
}
