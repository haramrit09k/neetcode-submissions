class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            intList.remove((Integer)nums[i]); // convert this to integer object, if you pass int primitive value, then it will treat it as index
            int prod = productOfNums(intList);
            res[i] = prod;
        }
        return res;
    }

    private static int productOfNums(List<Integer> intList){
        int prod = 1;
        for(Integer num: intList){
            prod *= num;
        }
        return prod;
    }
}  
