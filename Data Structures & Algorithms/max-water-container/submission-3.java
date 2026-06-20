class Solution {
    public int maxArea(int[] heights) {
        //two pointer solution
        int l = 0, r = heights.length - 1;
        int max = 0;
        while(l < r){
            int area = (r-l)*Math.min(heights[l], heights[r]);
            max = Math.max(max, area);
            if(heights[l] < heights[r]){
                int lastHeight = heights[l];
                l++;
                while(l < r && heights[l] <= lastHeight){
                    l++;
                }
            }
            else{
                int lastHeight = heights[r];
                r--;
                while(l < r && heights[r] <= lastHeight){
                    r--;
                }
            }
        }
        return max;
    }
}
