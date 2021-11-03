package ContactSorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Contact.Contact;
 

public class ContactSorters {
    public static boolean checkSort(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size() -1; i++) {
            System.out.println(".");
            if (contactList.get(i).nameNoSpace.compareTo(contactList.get(i + 1).nameNoSpace) > 0) {
                return false;
            }
        }//for
        return true;
    }

    public static ArrayList<Contact> bogoSort(ArrayList<Contact> myList) {
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


    public static ArrayList<Contact> bubbleSorter(ArrayList<Contact> contactList) {
        for (int stage = 0; stage < contactList.size(); stage++) {
            System.out.println("Stage: " + stage);
            for (int i = 0; i < contactList.size() - 1; i++) {
                //System.out.println(i);
                if (contactList.get(i).nameNoSpace.compareTo(contactList.get(i + 1).nameNoSpace) > 0) {
                    Contact temp = contactList.get(i);
                    contactList.set(i, contactList.get(i + 1));
                    contactList.set(i + 1, temp);
                }
            }
        }
        return contactList;
    }

    public static ArrayList<Contact> mergeLists(ArrayList<Contact> listOne, ArrayList<Contact> listTwo) {
        ArrayList<Contact> finalList = new ArrayList<>();
        while (listOne.size() > 0 && listTwo.size() > 0) {
            if (listOne.get(0).nameNoSpace.compareTo(listTwo.get(0).nameNoSpace) < 0) {
                finalList.add(listOne.get(0));
                listOne.remove(0);
            } else {
                finalList.add(listTwo.get(0));
                listTwo.remove(0);
            }
        }
        finalList.addAll(listOne);
        finalList.addAll(listTwo);
        return finalList;
    }
    public static ArrayList<Contact> mergeSort(ArrayList<Contact> contactList) {
        ArrayList<ArrayList<Contact>> listOfLists = new ArrayList<>();
        ArrayList<Contact> finalList = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            listOfLists.add(new ArrayList<Contact>(List.of(contactList.get(i))));
        }
        System.out.println(listOfLists.size());
        for (int i = 0; i < listOfLists.size(); i++) {
            finalList = mergeLists(finalList, listOfLists.get(i));
        }
        return finalList;
    }

}
