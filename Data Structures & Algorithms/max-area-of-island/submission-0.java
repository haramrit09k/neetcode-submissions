class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        } 
        grid[r][c] = 0;
        int area = 1;
        area += dfs(grid, r+1, c);
        area += dfs(grid, r-1, c);
        area += dfs(grid, r, c+1);
        area += dfs(grid, r, c-1);
        return area;
    }
}
