import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // selecting the first element (0th element)
        char ch = str.charAt(0);
        // create a substring form 1st element -> last element
        String ros = str.substring(1);
        ArrayList<String> rres = gss(ros);
        ArrayList<String> ans = new ArrayList<>();

        // exclude
        for (String i : rres) {
            ans.add(i);
        }

        for (String i : rres) {
            ans.add(ch + i);
        }

        return ans;
    }
}