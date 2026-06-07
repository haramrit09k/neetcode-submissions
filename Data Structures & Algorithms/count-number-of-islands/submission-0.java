class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int countIslands = 0;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }

    private static void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
