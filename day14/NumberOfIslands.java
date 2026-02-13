package day14;

public class NumberOfIslands {
    public static int numIslands(char[][] mat){
        if(mat==null||mat.length==0) return 0;
        int count = 0; int rSize = mat.length, cSize = mat[0].length;
        for(int row=0;row<rSize;row++)
            for(int col=0;col<cSize;col++)
                if(mat[row][col]=='1') 
                {count++;dTrav(mat, row, col);}
        return count;
    }
    public static void dTrav(char[][] mat, int row, int col){
        int rSize = mat.length, cSize = mat[0].length;
        if(row<0||col<0||row>=rSize||col>=cSize||mat[row][col]=='0') return;
        mat[row][col]='0';dTrav(mat, row-1, col);dTrav(mat, row+1, col);
        dTrav(mat, row, col-1);dTrav(mat, row, col+1);
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
}
