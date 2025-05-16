package backtracking;


public class NKnights {

    public static void main(String[] args) {
        int n= 4;
        boolean[][] board =new boolean[n][n];
        knights(board , 0,0,4);
    }

    static void knights(boolean[][] board,int row,int column, int knights) {
        if(knights == 0) {
            displayKnight(board);
            return;
        }
        if(row ==board.length-1 && column == board.length-1) {
            return;
        }

        if(column == board.length) {
            knights(board,row+1,0, knights);
            return;

        }

        if(isSafe(board,row,column)) {
            board[row][column] = true;
            knights(board,row,column+1,knights-1);
            board[row][column] = false;
        }
        knights(board,row,column+1,knights);


    }

    private static boolean isSafe(boolean[][] board, int row, int column) {
       if (isValid(board, row - 2, column -1) && board[row - 2][column - 1]) {
           return false;
       }
        if (isValid(board, row - 2, column +1) && board[row - 2][column + 1]) {
            return false;
        }
        if (isValid(board, row - 1, column -2) && board[row - 1][column - 2]) {
            return false;
        }
        if (isValid(board, row -1 , column + 2) && board[row - 1][column + 2]) {
            return false;
        }
       return true;
    }

    private static boolean isValid(boolean[][] board, int row, int column) {
        if(row>=0 && row< board.length-1 && column >=0 && column < board.length) return true;
        return false;
    }


    private static void displayKnight(boolean[][] queens) {
        for (boolean[] queen : queens ) {
            for (boolean ele: queen) {
                if(ele) {
                    System.out.print("KN  ");
                } else {
                    System.out.print("X   ");
                }
            }
            System.out.println();
        }
    }
}
