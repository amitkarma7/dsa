package backtracking;

import java.util.Arrays;

public class AllPaths {

    public static void main(String[] args) {
        boolean data[][]  = new boolean[][] { {true,true,true} , {true,true,true} ,{true,true,true} };
        int path[][]  = new int[][] { {0,0,0} ,{0,0,0} , {0,0,0} };

        allPathPrintKK("" , data , 0,0 ,path , 1);
    }

    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) return;
        maze[r][c] = false;
        if (r < maze.length - 1) {
            allPath(p + "V", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            allPath(p + "H", maze, r, c + 1);
        }
        if (r > 0) {
            allPath(p + "U", maze, r - 1, c);
        }
        if (c > 0) {
            allPath(p + "D", maze, r, c - 1);
        }
    }

    static void allPathBackTracking(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) return;
        maze[r][c] = false;
        if (r < maze.length - 1) {
            allPathBackTracking(p + "V", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            allPathBackTracking(p + "H", maze, r, c + 1);
        }
        if (r > 0) {
            allPathBackTracking(p + "U", maze, r - 1, c);
        }
        if (c > 0) {
            allPathBackTracking(p + "D", maze, r, c - 1);
        }

        // this line when function will over it.
        // so before the function gets removed, also removed the changes that made by that function
        maze[r][c] = true;

    }


    static void allPathPrint(String p, boolean[][] maze, int r, int c ,int[][] path ,int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int [] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println("--------------------------------------------------------------");
            return;
        }
        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrint(p + "V", maze, r + 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) {
            allPathPrint(p + "H", maze, r, c + 1, path, step + 1);
        }
        if (r > 0) {
            allPathPrint(p + "U", maze, r - 1, c, path, step + 1);
        }
        if (c > 0) {
            allPathPrint(p + "D", maze, r, c - 1, path, step + 1);
        }

        // this line when function will over it.
        // so before the function gets removed, also removed the changes that made by that function
        maze[r][c] = true;
        path[r][c] = 0;


    }

    static void allPathPrintKK(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrintKK(p + 'D', maze, r+1, c, path, step+1);
        }

        if (c < maze[0].length - 1) {
            allPathPrintKK(p + 'R', maze, r, c+1, path, step+1);
        }

        if (r > 0) {
            allPathPrintKK(p + 'U', maze, r-1, c, path, step+1);
        }

        if (c > 0) {
            allPathPrintKK(p + 'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }

}
