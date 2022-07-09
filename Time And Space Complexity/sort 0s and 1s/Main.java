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
//   public static int[] segregate0sand1s(int[] arr, int size){
//     int count0 = 0;
//     for (int i = 0; i < arr.length; i++) {
//         if(arr[i] == 0){
//             count0++;
//         }
//     }

//     int[] result = new int[size];
//     for (int i = 0; i < result.length; i++) {
//         if(i < count0){
//             result[i] = 0;
//         } else {
//             result[i] = 1;
//         }
//     }
//     return result;
//   }

  // method 2 to solve the problem
  // Use two indexes to traverse
  // both i and j starts from 0
//   public static int[] segregate0sand1s(int[] arr, int size){
//     int i = 0;
//     int j = 0;
//     while(i < size){
//         if(arr[i] == 1){
//             i++;
//         } else if(arr[i] == 0){
//             swap(arr, i++, j++);
//         }
//     }
//     return arr;
//   }

    // method 3 to solve the problem
    // Use two indexes to traverse
    // i = 0 and j = length - 1
    public static int[] segregate0sand1s(int[] arr, int size){
        int i = 0;
        int j = size - 1;

        while(i < j){
            if(arr[i] == 0){
                i++;
            } else if(arr[j] == 1){
                j--;
            }

            if(arr[i] == 1){
                if(arr[j] == 0){
                    swap(arr, i++, j--);
                } else if (arr[j] == 1){
                    j--;
                }
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