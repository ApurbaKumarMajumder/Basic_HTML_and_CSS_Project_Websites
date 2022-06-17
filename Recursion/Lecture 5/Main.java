import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();
        // printSS(str, "");
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> result = getMazePaths(0, 0, n-1, m-1);
        System.out.print(result);
    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String restOfQuestion = str.substring(1);
        printSS(restOfQuestion, ans+ch);
        printSS(restOfQuestion, ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // base case
        if(sr == dr && sc == dc){
            ArrayList<String> name = new ArrayList<String>();
            name.add("");
            return name;
        }

        // recursion will give me answers but I will start with my work
        ArrayList<String> myPath = new ArrayList<String>();

        // for all horizontal moves
        for(int jumps = 1; jumps <= dc - sc; jumps++){
            ArrayList<String> horizontalMoves = getMazePaths(sr, sc+jumps, dr, dc);
            for (String i : horizontalMoves) {
                myPath.add('h'+jumps+i);
            }
        }

        // for all vertical moves
        for(int jumps = 1; jumps <= dr - sr; jumps++){
            ArrayList<String> verticalMoves = getMazePaths(sr+jumps, sc, dr, dc);
            for (String i : verticalMoves) {
                myPath.add('v'+jumps+i);
            }
        }

        // for all diagonal moves
        for(int jumps = 1; jumps <= dc - sc && jumps <= dr - sr; jumps++){
            ArrayList<String> diagonalMoves = getMazePaths(sr+jumps, sc+jumps, dr, dc);
            for (String i : diagonalMoves) {
                myPath.add('d'+jumps+i);
            }
        }

        return myPath;
    }
}