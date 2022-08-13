import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // NQueen Question
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int[][] arr = new int[n][n];
        // printNQueens(arr, "", 0);
        
        // Knights Tour
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();

        int[][] arr = new int[n][n];

        printKnightsTour(arr, row, col, 0);
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

    public static void printKnightsTour(int[][] chess, int row, int col, int upcomingMove) {
        // outside the chess board or the box is already visited
        if(row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0){
            return;
        }

        // base case for chess board completion
        if(upcomingMove == chess.length * chess[0].length){
            chess[row][col] = upcomingMove;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        // mark the move you have done
        chess[row][col] = upcomingMove;

        // knight has 8 different moves
        printKnightsTour(chess, row - 2, col + 1 , upcomingMove + 1);
        printKnightsTour(chess, row - 1, col + 2 , upcomingMove + 1);
        printKnightsTour(chess, row + 1, col + 2 , upcomingMove + 1);
        printKnightsTour(chess, row + 2, col + 1 , upcomingMove + 1);
        printKnightsTour(chess, row + 2, col - 1 , upcomingMove + 1);
        printKnightsTour(chess, row + 1, col - 2 , upcomingMove + 1);
        printKnightsTour(chess, row - 1, col - 2 , upcomingMove + 1);
        printKnightsTour(chess, row - 2, col - 1 , upcomingMove + 1);

        // unmark the move
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}