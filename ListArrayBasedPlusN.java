
/*
 * Purpose: Honors Data Structure and Algorithms Lab 2 Problem 4
 * Status: Complete and thoroughly tested [choose only one!!!]
 * Last update: 09/20/22
 * Submitted:  09/20/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Lukas DeLoach
 * @version: 2022.20.09
 */
public class ListArrayBasedPlusN<T> extends ListArrayBased<T> {





    /**
     * New improved add method that does only 1 check.
     * Checks if it has to resize and if it does, copies elements up to the specified index
     * Then drops the element at the correct index and then copies the rest of the old array over.
     * @param index
     * @param item
     */
    public void add(int index, T item) {
        if(numItems==items.length) {
            T[] tmp = (T[]) new Object[1<<items.length];
            for(int i = 0; i < index; i++) {
                tmp[i] = items[i];
            }
            tmp[index] = item; //Dropping item in
            for(int i = index; i < numItems; i++) {
                tmp[i+1]=items[i];
            }
            numItems++;
            items = tmp;
        }
        else {
            super.add(index, item);
        }
    }

    /**
     * Overwritten add method inherited from ListArrayBased
     * First makes a check to see if numItems is equal to the size of the array.
     * If they are equal calls the classes private method resize.
     * After the array is resized calls the super add method which adds the item at the given index
     **
    public void add(int index, Object item) {
        if(numItems==items.length) {
            Object[] tmp = new Object[1<<items.length];
            int j = 0;
            for(int i = 0; i < numItems; i++) {
                if(i==index) {
                    tmp[i] = item;
                } else {
                    tmp[i] = items[j];
                    j++;
                }
            }
            items = tmp;
        }
        else {
            super.add(index, item);
        }
    }*/

    /**
     * Method to reverse the list.
     * First holds tmp Object
     * then iterates through half of the list.
     * Does some swaps and then assigns items with correct values.
     */
    public void reverse() {
        T tmp;
        for(int i = 0; i < numItems/2; i++) {
            tmp = items[i];
            items[i] = items[numItems-i-1];
            items[numItems-i-1]=tmp;
        }
    }

    /**
     * Method toString
     * Returns a String builder of appended items in the list
     * @return s.toString()
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            s.append(items[i] + " ");
        }
        return s.toString();
    }
}
