class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> el = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(el);
                        res.add(el);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}
