class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int currSum = 0;

        while(l < r){
            currSum = numbers[l] + numbers[r];
            if(target == currSum){
                return new int[] {l+1, r+1};
            }
            else if(target < currSum){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}
