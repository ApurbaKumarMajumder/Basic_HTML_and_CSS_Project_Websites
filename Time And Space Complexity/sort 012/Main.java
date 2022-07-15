import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

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
    result = segregate012(arr, size);
    print(result);
  }

    public static int[] segregate012(int[] arr, int size){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) {
          if(arr[mid] == 0){
            swap(arr, low++, mid++);
          } 
          else if(arr[mid] == 2){
            swap(arr, high--, mid++);
          } else {
            mid++;
          }
        }
        
        return arr;
    }

  // swap function implemented
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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