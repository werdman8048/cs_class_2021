package bogoSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Scanner;

public class bogosortAssignment {
    static boolean checkSort(ArrayList<Integer> listIn) {
        for (int i = 0; i < listIn.size() - 1; i++) {
            System.out.print(".");
            if (listIn.get(i) > listIn.get(i + 1)) {
                return false;
            }//if
        }//for loop
        return true;
    }//check sort
 /*
    static Contact inputContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's the contact's name?");
        String name = scanner.nextLine();
        System.out.println("What's the contact's address?");
        String address = scanner.nextLine();
        System.out.println("What's the contacts phone number (numbers only, no special characters)");
        int phoneNum = scanner.nextInt();

        scanner.close();
        Contact myContact = new Contact(name, address, phoneNum);
        return myContact;
    }//input contact*/

    public static ArrayList<Integer> bogoSort(ArrayList<Integer> myList) {
        int counter = 0;
        while (true) {
            counter++;
            Collections.shuffle(myList);
            if (checkSort(myList)) {
                System.out.println(myList);
                System.out.println("It took " + counter + " tries.");
                return myList;
            }
        }//while

    }

    public static void main(String[] args) {

        System.out.println("I'm not sure if you'll end up reading my comments, but how do you want the Contact objects to be sorted?");
        
        ArrayList<Integer> myList = new ArrayList<Integer>(List.of(3, 2, 45, 5, 43, 22, 7));

        //leaving this as sorting integers, should take just a few edits to make it sort contacts, however, not sure what exacty i should be sorting them by as the instructions didn't say

        bogoSort(myList);

    }//main
}//bogosortAssignment