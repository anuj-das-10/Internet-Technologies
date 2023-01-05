// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 2. Write a JAVA program to sort the list of numbers using Collection Framework. (Using Method of Collections)

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.print("Enter the size of the List:  ");
        int size = sc.nextInt();
        System.out.println("Enter "+size+" Elements:  ");
        for(int i = 0; i < size; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("List Before Sorting:  ");
        list.forEach(element -> System.out.print(element+"   "));

        Collections.sort(list);
        System.out.print("\nList After ASC Sort:  ");
        list.forEach(element -> System.out.print(element+"   "));

        Collections.sort(list, Collections.reverseOrder());
        System.out.print("\nList After DSC Sort:  ");
        list.forEach(element -> System.out.print(element+"   "));

    }    
}
