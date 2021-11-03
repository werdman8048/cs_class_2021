package bubbleSort;

import java.util.ArrayList;
import java.util.List;

public class bubbleSort {
    public static ArrayList<Integer> bubble_sort(ArrayList<Integer> list) {
        for (int stage = 0; stage < list.size(); stage++) {
            System.out.println("Stage: " + stage);
            for (int i = 0; i < (list.size() - 1); i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    //System.out.println(list);
                }//if
                System.out.println(list);
            }//for 
        }//big for
        return list;
    }//static thing
    public static void main(String args[]) {
        ArrayList<Integer> myList = new ArrayList<Integer>(List.of(3, 2, 45, 5, 43, 22, 7));
        System.out.println(bubble_sort(myList));
    }//main
}
