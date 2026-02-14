package day15;

public class SourroundedRegions {
    static int rSize, cSize;
    public static void solve(char[][] board){
        if(board==null|board.length==0) return;
        rSize = board.length; cSize = board[0].length;
        for(int index=0;index<rSize;index++){
            depthForSurround(board, index, 0);
            depthForSurround(board, index, cSize-1);
        }
        for(int index=0;index<cSize;index++){
            depthForSurround(board, 0,index);
            depthForSurround(board, rSize-1,index);
        }
        for(int row=0;row<rSize;row++)
            for(int col=0;col<cSize;col++)
                if(board[row][col]=='O') board[row][col]='X';
                else if(board[row][col]=='#') board[row][col] = 'O';
    }
    public static void depthForSurround(char[][] board,int row, int col){
        if(row<0||col<0||row>=rSize||col>=cSize||board[row][col]!='O')
            return;
        board[row][col]='#';
        depthForSurround(board, row+1, col);
        depthForSurround(board, row-1, col);
        depthForSurround(board, row, col-1);
        depthForSurround(board, row, col+1);
    }
}
