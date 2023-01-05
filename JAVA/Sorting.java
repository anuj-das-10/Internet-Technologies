// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 2. Write a JAVA program to sort the list of numbers using Collection Framework. (Implementation of Bubble Sort)

import java.util.Scanner;
import java.util.ArrayList;

public class Sorting {
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

// Bubble Sort Algorithm for Ascending Order!
    Integer temp;
    for(int i = 0; i < size - 1; i++) {
        for(int j = 0; j < size - 1 - i; j++) {
            if(list.get(j) > list.get(j+1)) {
                temp = list.get(j);
                list.set(j, list.get(j+1));
                list.set(j+1, temp);
            }
        }
    }

        System.out.print("\nList After  Sorting:  ");
        list.forEach(element -> System.out.print(element+"   "));
    }
}
