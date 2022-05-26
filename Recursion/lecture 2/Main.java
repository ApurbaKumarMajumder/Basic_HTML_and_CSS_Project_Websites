import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int scr = scn.nextInt();
        int dest = scn.nextInt();
        int helper = scn.nextInt();
        toh(n, scr, dest, helper);
    }

    public static void toh(int n, int scr, int dest, int helper){
        if(n == 0){
            return;
        }
        toh(n-1, scr, helper, dest);
        System.out.println(n+"["+scr+"->"+dest+"]");
        toh(n-1, helper, dest, scr);
    }
// 1:17
}