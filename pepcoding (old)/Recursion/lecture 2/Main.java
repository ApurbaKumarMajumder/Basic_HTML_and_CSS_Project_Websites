import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int scr = scn.nextInt();
        // int dest = scn.nextInt();
        // int helper = scn.nextInt();
        // toh(n, scr, dest, helper);
        pzz(n);
    }

    public static void toh(int n, int scr, int dest, int helper){
        if(n == 0){
            return;
        }
        toh(n-1, scr, helper, dest);
        System.out.println(n+"["+scr+"->"+dest+"]");
        toh(n-1, helper, dest, scr);
    }

    public static void pzz(int n){
        if(n < 1){
            return;
        }

        System.out.println("Pre ");
        System.out.println(n);
        pzz(n-1);
        System.out.println("Post ");
        System.out.println(n);
        pzz(n-1);
        System.out.println("Last ");
        System.out.println(n);
    }
}