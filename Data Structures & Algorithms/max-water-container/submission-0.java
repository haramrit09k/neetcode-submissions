class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxWater = 0, currWater = 0;
        while(i < j){
            currWater = (Math.min(heights[i], heights[j]))*(Math.abs(j-i));
            maxWater = Math.max(maxWater, currWater);
            if(heights[i] <= heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxWater;
    }
}
