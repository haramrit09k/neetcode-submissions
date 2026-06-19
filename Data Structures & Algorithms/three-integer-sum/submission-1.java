class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> threeSum = twoSumTarget(nums, i+1, target - nums[i]);
            for(List<Integer> tuple: threeSum){
                tuple.add(nums[i]);
                Collections.sort(tuple);
                res.add(tuple);
            }
        }
        return new ArrayList<List<Integer>>(res);
    }

    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target){
        int l = start, r = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(l < r){
            int sum = nums[l] + nums[r];
            int left = nums[l], right = nums[r];
            if(sum < target){
                while(l < r && nums[l] == left) l++;
            }
            else if (sum > target){
                while(l < r && nums[r] == right) r--;
            }
            else {
                res.add(new ArrayList<Integer>(Arrays.asList(nums[l], nums[r])));
                while(l < r && nums[l] == left) l++;
                while(l < r && nums[r] == right) r--;
            }
        }
        return res;
    }

}
