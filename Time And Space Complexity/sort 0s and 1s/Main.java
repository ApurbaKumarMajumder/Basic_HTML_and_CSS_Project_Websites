import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int size = scn.nextInt();
    int[] arr = new int[size];
    
    // array input
    for (int i = 0; i < size; i++) {
      arr[i] = scn.nextInt();
    }

    int[] result = new int[size];
    result = segregate0sand1s(arr, size);
    print(result);
  }

  // Method 1 to solve the problem
  // count the number of 0s and 1s and create a new result array according to that
  public static int[] segregate0sand1s(int[] arr, int size){
    int count0 = 0;
    for (int i = 0; i < arr.length; i++) {
        if(arr[i] == 0){
            count0++;
        }
    }

    int[] result = new int[size];
    for (int i = 0; i < result.length; i++) {
        if(i < count0){
            result[i] = 0;
        } else {
            result[i] = 1;
        }
    }
    return result;
  }

  // function to print array
  static void print(int arr[]){
    int n = arr.length;
    System.out.print("Array after segregation is ");
    for (int i = 0; i < n; i++){
        System.out.print(arr[i] + " ");
    }
  }
}