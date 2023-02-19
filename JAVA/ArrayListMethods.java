// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 1. Write a JAVA program to explore the different methods of ArrayList class.

import java.util.ArrayList;

class ArrayListMethods {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Anuj");       list.add("Kevin");
        list.add("Kaynath");    list.add("John");
        list.add("William");    list.add("Scarlet");

        System.out.print("Before:  ");

        list.forEach(element -> System.out.print(element+"   "));

        if(list.contains("John")) {
            list.set(list.indexOf("John"), "Johnson");
            list.remove("Scarlet");
        }
        System.out.println("");
        System.out.print("After :  ");

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"   ");
        }
    }
}

// get(), set(), size(), indexOf(), forEach(), contains(), remove()
