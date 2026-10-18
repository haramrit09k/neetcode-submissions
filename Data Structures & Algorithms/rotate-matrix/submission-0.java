class Solution {
    public void rotate(int[][] matrix) { // transpose + reverse = rotate image
        
        int n = matrix.length;

        // step 1 - transpose
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // step 2 - reverse
        for(int i = 0; i < n; i++){
            int l = 0, r = n-1;
            while(l < r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
