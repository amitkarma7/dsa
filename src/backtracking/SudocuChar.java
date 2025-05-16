package backtracking;

import java.util.Arrays;
import java.util.List;

public class SudocuChar {

    public static void main(String[] args) {
        SudocuChar sudocuChar =new SudocuChar();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };


        sudocuChar.solveSudoku(board);
        display(board);

    }
    static void display(char[][] board) {
        for (char[] nums : board) {
            for (char num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        int n = board.length;
        int row =-1;
        int col =-1;

        boolean emptyLeft = false;

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(board[i][j] == '.') {
                    row= i;
                    col =j;
                    emptyLeft = true;
                    break;
                }
            }
            if(emptyLeft == true) {
                break;
            }
        }

        if(emptyLeft==false)  {
            return true;
        }

        for(int num = 1;num <=9;num++) {

            if(isSafe(board,row,col, '0' + num)) {
                board[row][col] =  (char)('0'+num);
                if(solve(board)) {
                    return true;
                } else {
                    board[row][col] =  '.';
                }
            }
        }

        return false;
    }

    boolean isSafe(char[][] board,  int row, int col, int num) {

        for(int i = 0; i<board.length;i++) {
            if(board[row][i] == num) {
                return false;
            }
        }

        for(int i = 0; i<board.length;i++) {
            if(board[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
