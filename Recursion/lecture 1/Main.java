import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
        printIncreasing(n);
        pdi(n);
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
        // 1:8mins
    }

    public static void pdi(int n){
        if (n == 0) {
            return;
        }

        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }
}