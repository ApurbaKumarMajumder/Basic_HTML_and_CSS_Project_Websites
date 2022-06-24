import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        printNQueens(arr, "", 0);
    }

    public static boolean isQueenSafe(int[][] arr, int row, int col){
        // queen moving up
        for(int i=row, j=col; i>=0; i--){
            if(arr[i][j] == 1){
                return false;
            }
        }

        // queen moving diogonal in left direction 
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(arr[i][j] == 1){
                return false;
            }
        }

        // queen moving diogonal in right direction
        for(int i=row, j=col; i>=0 && j<arr[0].length; i--, j++){
            if(arr[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    public static void printNQueens(int[][] chess, String asf, int row) {
        if(row == chess.length){
            System.out.println(asf + ".");
            return;
        }

        for(int col=0; col<chess[0].length; col++){
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, asf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }
}