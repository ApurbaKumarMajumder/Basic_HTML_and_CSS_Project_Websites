import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();
        // ArrayList<String> res = gss(str);
        // System.out.println(res);
        // int n = scn.nextInt();
        // ArrayList<String> res = getStairPaths(n);
        // System.out.println(res);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        ArrayList<String> ans = getMazePaths(0, 0, dr - 1, dc - 1);
        System.out.println(ans);
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

    public static ArrayList<String> getStairPaths(int n) {
        // This is a proactive approach
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myPath = new ArrayList<>();

        if(n >= 1){
            // 1 step
            ArrayList<String> path1Step = getStairPaths(n-1);
            for (String path : path1Step) {
                myPath.add('1' + path);
            }
        }

        if(n >= 2){
            // 2 steps
            ArrayList<String> path2Step = getStairPaths(n-2);
            for (String path : path2Step) {
                myPath.add('2' + path);
            }
        }

        if(n >= 3){
            // 3 steps
            ArrayList<String> path3Step = getStairPaths(n-3);
            for (String path : path3Step) {
                myPath.add('3' + path);
            }
        }

        return myPath;
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // This is a reactive code
        if(sr > dr || sc > dc){ // invalid
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        if(sr == dr && sc == dc){ // valid 
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> hpath = getMazePaths(sr, sc+1, dr, dc); // vertical
        ArrayList<String> vpath = getMazePaths(sr+1, sc, dr, dc); // Horizontal

        ArrayList<String> path = new ArrayList<>();
        for(String p: hpath){
            path.add('h'+p);
        }
        for(String p:vpath){
            path.add('v'+p);
        }

        return path;
    }
}