class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;

        List<List<Integer>> res = new ArrayList<>();
        
        // Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            
            // Neetcode solution gotcha #1 - since array is sorted, 
            //there will be no set of numbers which can yield 0 
            // if the first number (supposedly smaller number) is +ve

            if(nums[i] > 0) break;
            
            // Use in conjunction with res as ArrayList (replace instead of HashSet)
            if (i > 0 && nums[i] == nums[i-1]) continue;

            twoSumTarget(nums, i+1, target - nums[i], nums[i], res);
            // for(List<Integer> tuple: threeSum) {
            //     tuple.add(nums[i]);
            //     Collections.sort(tuple);
            //     res.add(tuple);
            // }
        }
        // return new ArrayList<List<Integer>>(res);
        return res;
    }

    public void twoSumTarget(int[] nums, int start, int target, int first, List<List<Integer>> res){
        int l = start, r = nums.length - 1;
        // List<List<Integer>> res = new ArrayList<>();
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
                res.add(new ArrayList<Integer>(Arrays.asList(first, nums[l], nums[r])));
                while(l < r && nums[l] == left) l++;
                while(l < r && nums[r] == right) r--;
            }
        }
        // return res;
    }

}
