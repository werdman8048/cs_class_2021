import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Contact.Contact;
import ContactSorters.ContactSorters;


public class contactSort {
    public static String buildString(String[] list) {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            value.append(list[i]);
        }
        return value.toString();
    }
    public static ArrayList<Contact> parseContactsFile() {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        try { 
            Scanner in = new Scanner(new File ("cs_class_2021/data_to_parse.txt"));
            String topLine = in.nextLine();
            while (in.hasNext()) {
                String strinLine = in.nextLine();
                String[] splitLine = strinLine.split("\\s+");
                contactList.add(new Contact(buildString(new String[]{splitLine[0], splitLine[1]}), buildString(new String[]{splitLine[0], " ", splitLine[1]}), splitLine[2], buildString(new String[]{splitLine[3], " ", splitLine[4], " ", splitLine[5]})));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        //System.out.println(contactList);
        return contactList;
        
    }


    public static void main(String[] args) {
        int inputnum = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to my sorting algorithms");

        while (inputnum != 0)  {
            System.out.println("\nEnter the number corresponding to the program you want to run");
      
            System.out.println("0:  Quit the program");
            System.out.println("1:  Bogosort");
            System.out.println("2:  Bubblesort");
            System.out.println("3:  Mergesort");
      
            inputnum = scanner.nextInt();
      
            switch (inputnum) {
              case 0: break;
              case 1:
                ArrayList<Contact> contactList = ContactSorters.bogoSort(parseContactsFile());
                for (int i = 0; i < contactList.size(); i++) {
                    Contact myContact = contactList.get(i);
                    System.out.println(myContact.name + " " + myContact.age + " " + myContact.address);
                }
                break;
               case 2:
                ArrayList<Contact> contactList1 = ContactSorters.bubbleSorter(parseContactsFile());
                for (int i = 0; i < contactList1.size(); i++) {
                    Contact myContact = contactList1.get(i);
                    System.out.println(myContact.name + " " + myContact.age + " " + myContact.address);
                }
                break;
               case 3: 
                ArrayList<Contact> contactList2 = ContactSorters.mergeSort(parseContactsFile());
                for (int i = 0; i < contactList2.size(); i++) {
                    Contact myContact = contactList2.get(i);
                    System.out.println(myContact.name + " " + myContact.age + " " + myContact.address);
                }
                break;
              default: System.out.println("Illegal value entered");
            }//switch
          }//while
          scanner.close();
    }
}
