package day9;

public class EditDistance {
    public static int minDistance(String src, String dest){
        int rSize = src.length(), cSize = dest.length();
        int[][] grid = new int[rSize+1][cSize+1];
        for(int col=0;col<=cSize;col++) grid[0][col] = col;
        for(int row=0;row<=rSize;row++) grid[row][0] = row;
        for(int row=1;row<=rSize;row++){
            for(int col=1;col<=cSize;col++){
                if(src.charAt(row-1)==dest.charAt(col-1))
                    grid[row][col]=grid[row-1][col-1];
                else{
                    grid[row][col] = 1 + Math.min(grid[row-1][col-1],
                        Math.min(grid[row-1][col],grid[row][col-1]));
                }
            }
        }
        return grid[rSize][cSize];
    }
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("horse", "rose"));
        System.out.println(minDistance("interntion", "execution"));
    }
}
