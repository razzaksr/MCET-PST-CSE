package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloringBorder {
    boolean[][] visited;
    int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] grid;
    int original;
    List<int[]> borders = new ArrayList<>();
    public int[][] shade(int[][] grid,int row, int col, int color){
        this.grid = grid; original = grid[row][col];
        visited = new boolean[grid.length][grid[0].length];
        depthForBorders(row, col);
        for(int[] dir:borders) grid[dir[0]][dir[1]] = color;
        return grid;
    }
    public void depthForBorders(int row, int col){
        visited[row][col] = true;
        int countSame = 0;
        for(int[] dir:direct){
            int cr = row+dir[0], cc = col+dir[1];
            if(cr>=0&&cc>=0&&cr<grid.length&&cc<grid[0].length){
                if(grid[cr][cc]==original){
                    countSame++;
                    if(!visited[cr][cc]) depthForBorders(cr,cc);
                }
            }
        }
        if(countSame<4) borders.add(new int[]{row,col});
    }
    public static void main(String[] args) {
        int[][] result = new CloringBorder().shade(new int[][]{
            {1,1},{1,2}}, 0, 0, 3);
        for(int[] row:result) System.out.println(Arrays.toString(row));
    }
}
