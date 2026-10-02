class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){ //1 = unvisited
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    void dfs(int r, int c, char[][] grid){

        if(
            r < 0 || c < 0 || 
            r >= grid.length || c >= grid[0].length
        ) { // out of bounds
            return;
        }

        if(grid[r][c] == '0'){ // already visited
            return;
        }

        grid[r][c] = '0'; //mark visited = 0
        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);
    }
}
