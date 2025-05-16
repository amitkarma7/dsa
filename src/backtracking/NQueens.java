package backtracking;

import java.util.Arrays;

public class NQueens {

    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];

        System.out.println(queens(board , 0));

    }

    static int queens(boolean[][] board , int row) {
            if(row == board.length) {
                displayBoard(board);
                System.out.println("-----------------------------------");
                return 1;
            }
            int count =0;
            // placing the queens and checking for row and column
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)) {
                board[row][col] = true;
                count+=queens(board,row+1);
                board[row][col] = false;

            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
            // check for entire row
        for (int i = 0; i <row; i++) {
            if(board[i][col]) return false;
        }

        // checkingdiagonal left
        int maxLeft = Math.min(row,col);
        for (int i = 0; i <=maxLeft; i++) {
            if(board[row-i][col-i]) return false;
        }

        // checkingdiagonal right
        int maxRight = Math.min(row,board.length-1-col);
        for (int i = 0; i <=maxRight; i++) {
            if(board[row-i][col+i]) return false;

        }
        return true;

    }

    private static void displayBoard(boolean[][] queens) {
        for (boolean[] queen : queens ) {
            for (boolean ele: queen) {
                if(ele) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
