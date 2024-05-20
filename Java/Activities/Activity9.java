package Activities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
      /*   ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");
        //Adding object at specific index
        myList.add(3, "Grapes");
        myList.add(1, "Papaya");

        System.out.println("Print All the Objects:");
       for(String s:myList){
            System.out.println(s);
        }

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Chicku is in list: " + myList.contains("Chicku"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("Papaya");

        System.out.println("New Size of ArrayList: " + myList.size());
    }*/

        Set<String> mySet = new HashSet<>();
        //Adding objects to Array List at default index
        mySet.add("Apple");
        mySet.add("Mango");
        mySet.add("Orange");
        //Adding object at specific index
      //  mySet.add(3, "Grapes");
       // mySet.add(1, "Papaya");

        System.out.println("Print All the Objects:");
        for(String s:mySet){
            System.out.println(s);
        }

//System.out.println("3rd element in the list is: " + mySet.get(2));
        System.out.println("Is Chicku is in list: " + mySet.contains("Chicku"));
        System.out.println("Size of ArrayList: " + mySet.size());

        mySet.remove("Papaya");

        System.out.println("New Size of ArrayList: " + mySet.size());
}}
