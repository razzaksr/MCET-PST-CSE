package day14;

import java.util.LinkedList;
import java.util.Queue;

public class EottingOranges {
    public static int orangesRotting(int[][] grid){
        int rSize = grid.length, cSize = grid[0].length, fresh=0,mint=0;
        // down, up, right, left
        int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
        int size = 0, x = 0, y=0;
        Queue<int[]> que = new LinkedList<>();
        for(int row=0;row<rSize;row++){
            for(int col=0;col<cSize;col++){
                if(grid[row][col]==2) 
                    que.offer(new int[]{row,col});
                if(grid[row][col]==1) 
                    fresh++;
            }
        }
        while(!que.isEmpty()&&fresh>0){
            size = que.size();
            for(int index=0;index<size;index++){
                int[] current = que.poll();
                for(int[] each:direct){
                    x = current[0]+each[0]; y=current[1]+each[1];
                    if(x<0||y<0||x>=rSize||y>=cSize||grid[x][y]!=1) continue;
                    grid[x][y] = 2; fresh--; que.offer(new int[]{x,y});
                }
            }
            mint++;
        }
        return fresh==0?mint:-1;
    }
    public static void main(String[] args) {
        int[][] fruits = {{2,1,1,},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(fruits));
    }
}
