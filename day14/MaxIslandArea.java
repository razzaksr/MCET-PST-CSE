package day14;

public class MaxIslandArea {
    public static int maxAreaOfIsland(int[][] grid){
        int maxArea = 0, rSzie = grid.length;
        int cSize = grid[0].length, currentMax=0;
        for(int row=0;row<rSzie;row++){
            for(int col=0;col<cSize;col++){
                if(grid[row][col]==1){
                    currentMax=survey(grid, row, col);
                    maxArea = Math.max(currentMax, maxArea);
                }
            }
        }
        return maxArea;
    }
    public static int survey(int[][] grid, int row, int col){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]==0)
            return 0;
        grid[row][col] = 0; int count = 1;count+=survey(grid, row+1, col);
        count+=survey(grid, row-1, col);count+=survey(grid, row, col-1);
        count+=survey(grid, row, col+1);
        return count;
    }
}
