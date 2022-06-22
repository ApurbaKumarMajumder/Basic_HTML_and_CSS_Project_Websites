import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // printPermutations Questions 
        // Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();
        // printPermutations(str, "");

        // Flood Fill Questions
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "");
    }

    public static void printPermutations(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char currentCharacter = str.charAt(i);
            String leftSideOfcc = str.substring(0, i); // i is not included
            String rightSideOfcc = str.substring(i+1); // i+1 to the end
            String restOfString = leftSideOfcc + rightSideOfcc;

            // recursive call for the answer
            printPermutations(restOfString, asf + currentCharacter);
        }
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int row, int col, String asf) {
        // negative base case
        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1){
            return;
        }

        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(asf);
            return;
        }

        maze[row][col] = 1;
        // top
        floodfill(maze, row - 1, col, asf + "t");
        // left
        floodfill(maze, row, col - 1, asf + "l");
        // bottom
        floodfill(maze, row + 1, col, asf + "d");
        // right
        floodfill(maze, row, col + 1, asf + "r");
        maze[row][col] = 0;
    }
}