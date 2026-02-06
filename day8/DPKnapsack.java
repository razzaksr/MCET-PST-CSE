package day8;

public class DPKnapsack {
    public static int takeOrSkip(int[] values, int[] wts, int capacity){
        int size = wts.length;
        int[][] grid = new int[size+1][capacity+1];
        for(int index = 1;index<=size;index++){
            for(int cw=0;cw<=capacity;cw++){
                if(wts[index-1]<=cw){
                    /* max between (values[i-1]+diagnoal value of grid 
                     from current row and\\ column) and previous row's same column
                    */
                    grid[index][cw] = Math.max(
                        values[index-1]+grid[index-1][cw-wts[index-1]],
                        grid[index-1][cw]
                    );
                }
                else
                    // copy previous row's same column from current cw position 
                    grid[index][cw] = grid[index-1][cw];
            }
        }        
        return grid[size][capacity];
    }
    public static void main(String[] args) {
        int[] weights = {4,5,1};
        int[] values={1,2,3};
        int cap = 4;
        System.out.println(takeOrSkip(values, weights, cap));
        int[] weights1 = {5,4,2,3};
        int[] values1={10,40,30,50};
        int cap1 = 5;
        System.out.println(takeOrSkip(values1, weights1, cap1));
    }
}
