class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        //upper = pacific, bottom = atlantic
        for(int c = 0; c < COLS; c++){
            dfs(0, c, pacific, heights[0][c], heights);
            dfs(ROWS-1, c, atlantic, heights[ROWS-1][c], heights);
        }

        // left = pacific, right = atlantic
        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pacific, heights[r][0], heights);
            dfs(r, COLS-1, atlantic, heights[r][COLS-1], heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    public static void dfs(int r, int c, boolean[][] visited, int prevHeight, int[][] heights){
        if(r < 0 || c < 0 ||
            r >= heights.length || c >= heights[0].length ||
            visited[r][c] || heights[r][c] < prevHeight
        ){
            return;
        }
        visited[r][c] = true;
        dfs(r+1, c, visited, heights[r][c], heights);
        dfs(r-1, c, visited, heights[r][c], heights);
        dfs(r, c+1, visited, heights[r][c], heights);
        dfs(r, c-1, visited, heights[r][c], heights);
    }
}
