// import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        printDecreasing(n);
        printIncreasing(n);
        pdi(n);
        System.out.println(factorial(n));
        System.out.println(power(x, n));
        System.out.println(exponentialPower(x, n));
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

    public static int factorial(int n){
        // if(n == 0) return 1;

        if(n == 1) return 1;

        return n * factorial(n-1);
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        return x * power(x, n-1);
    }

    public static int exponentialPower(int x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        int xPowNBy2 = power(x, n/2);
        int ans = xPowNBy2 * xPowNBy2;
        if(n%2 == 1){
            ans = ans * x;
        }
        return ans;
    }
}