import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bubbleSort.bubbleSort;
import bogoSort.bogosortAssignment;

public class combinedSorting {
    public static void main(String args[]) {
        ArrayList<Integer> myList = new ArrayList<Integer>(List.of(3, 2, 45, 5, 43, 22, 13, 67)); //, 23, 324, 53, 8, 9, 1, -1, 7

        int inputnum = -1;

        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nWelcome to my sorting algorithms");
    
        while (inputnum != 0)  {
          System.out.println("\nEnter the number corresponding to the program you want to run");
    
          System.out.println("0:  Quit the program");
          System.out.println("1:  Bogosort");
          System.out.println("2:  Bubblesort");
    
          inputnum = scanner.nextInt();
    
          switch (inputnum) {
            case 0: break;
            case 1: bogosortAssignment.bogoSort(myList);
                    break;
            case 2: bubbleSort.bubble_sort(myList);
                    break;
            default: System.out.println("Illegal value entered");
          }//switch
        }//while
        scanner.close();
      }//main
}
