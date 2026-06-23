class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        int res = 0;

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int j = n-2; j > 0; j--){
            rightMax[j] = Math.max(height[j], rightMax[j+1]);
        }

        for(int i = 0; i < n; i++){
            if(Math.max(leftMax[i], rightMax[i]) - height[i] > 0){
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return res;
    }
}
