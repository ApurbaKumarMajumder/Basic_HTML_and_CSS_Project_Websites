import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // printIncreasing(n);
        printDecreasing(n);
    }

    public static void printIncreasing(int n){
        if(n == 0) return;

        // faith
        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static void printDecreasing(int n){
        if(n == 0) return;

        // expectation
        System.out.println(n);
        // faith
        printDecreasing(n - 1);
    }
}