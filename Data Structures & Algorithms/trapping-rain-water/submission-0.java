class Solution {
    // brute force solution
    public int trap(int[] height) {
        
        int res = 0;
        int n = height.length;

        if(n == 0 || height == null) return 0;

        for(int i = 0; i<n; i++){
            int leftMax = height[0];
            int rightMax = height[n - 1];

            for(int j = 0; j< i; j++){
                leftMax = Math.max(leftMax, height[j]);
            }

            for(int j = i+1; j <n; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            if(Math.min(leftMax, rightMax) > height[i]){
                res+= Math.min(leftMax, rightMax) - height[i];
            }
        }

        return res;
    }
}
