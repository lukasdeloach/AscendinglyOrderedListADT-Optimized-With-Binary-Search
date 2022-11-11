/*
 * Purpose: Honors Data Structure and Algorithms Lab 8 Problem 4
 * Status: Complete and thoroughly tested
 * Last update: 11/08/22
 * Submitted:  11/08/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Lukas DeLoach
 * @version: 2022.08.11
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Lab8Problem4Driver {


    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[]args) throws IOException {

        AscendinglyOrderedList<Item, String> list = new AscendinglyOrderedList<>();
        System.out.println("Select from the following menu:");
        System.out.println("0. Exit program. \n1. Insert item to list.\n2. Remove item from list. \n3. Get item from list. \n4. Search for specific item in the list. \n5. Clear list. \n6. Print size and content of list.");
        System.out.print("Make your menu selection now: ");
        String s = in.readLine().trim();
        int i = convertToInt(s);
        System.out.println(i);

        while(i>=1) {
            switch(i) {
            case 1:
                inputCaseOne(list);
                break;
            case 2:
                inputCaseTwo(list);
                break;
            case 3:
                inputCaseThree(list);
                break;
            case 4:
                inputCaseFour(list);
                break;
            case 5:
                list.removeAll();
                break;
            case 6:
                inputCaseSix(list);
                break;
            }
            System.out.print("Make your menu selection now: ");
            s = in.readLine().trim();
            i = convertToInt(s);
            System.out.println(i);
        }
        System.out.println("Exisitng program...Good Bye");

    }

    /**
     * Responsible for the addition of an element
     * @param list
     * @throws IOException
     */
    private static void inputCaseOne(AscendinglyOrderedList<Item, String> list) throws IOException {
        System.out.println("You are now inserting an item into the list.");
        System.out.print("\tEnter item: ");

        String name = in.readLine().trim();
        System.out.println(name);
        list.add(new Item(name, false, 0));
    }


    /**
     * Responsible for the deltion of an element.
     * @param list
     */
    private static void inputCaseTwo(AscendinglyOrderedList<Item, String> list) {
        if(!list.isEmpty()) {
            System.out.print("\tEnter position to remove item from: ");
            try {
                int s = convertToInt(in.readLine().trim());
                System.out.println(s);
                if(s>=0&&s<list.size()) {
                    System.out.println("Item " + list.get(s).toString() + " removed");
                    list.remove(s);
                }
                else {
                    System.out.println("Invalid index");
                }
            } catch(Exception e) {
                System.out.println("Error");
            }
        }
    }



    /**
     * Method input case three that determines if item is in list then returns it
     * @param list
     */
    private static void inputCaseThree(AscendinglyOrderedList<Item, String> list) {
        System.out.print("\t Enter position to retrieve item from: ");
        try {
            int s = convertToInt(in.readLine().trim());
            System.out.println(s);
            System.out.println("Item " + list.get(s).toString() + " retrieved from position " + s + " in the list.");
        } catch(Exception e) {
            System.out.println("Error");
        }
    }

    private static void inputCaseFour(AscendinglyOrderedList<Item, String> list) throws IOException {
        System.out.print("\t Please enter the item you would like to search for: ");
        String input = in.readLine().trim();
        System.out.println(input);
        int result = list.search(input);
        if(result <= 0) {
            result+=list.size();
            System.out.println("Item " + input + " found at index " + result);
        }
        else {
            System.out.println("Item " + input + " not found in collection");
        }
    }


    /**
     * First makes a check to make sure that the input case is not null, if not prints statement
     * @param list
     */
    private static void inputCaseSix(AscendinglyOrderedList<Item, String> list) {
        if(list.isEmpty()) {
            System.out.println("List is empty.");
        }
        else {
            System.out.println("List of size " + list.size() + " has the following items: " + list.toString());
        }
    }


    /**
     * Method to convert to an integer from a string
     * @param s
     * @return i
     */
    private static int convertToInt(String s) {
        int i = -1;
        try {
            i = Integer.parseInt(s);
        }
        catch(Exception e) {
            System.out.println("Invalid number.");
        }
        return i;
    }
}
