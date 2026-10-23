class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while(left < right && top < bottom){
            // process every i in top row
            for(int i = left; i < right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            // process every i in right col
            for(int i = top; i < bottom; i++){
                res.add(matrix[i][right-1]);
            }
            right--;

            // again check while condition
            if(left >= right || top >= bottom){
                break;
            }

            // process every i in bottom row
            for(int i = right-1; i >= left; i--){
                res.add(matrix[bottom-1][i]);
            }
            bottom--;

            // process every i in left col
            for(int i = bottom-1; i >= top; i--){
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
