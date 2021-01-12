/* *****************************************************************************
 *  Name: Courtney Hoppus
 *  Date: 2021-01-11
 *  Description: Assignment 1
 **************************************************************************** */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Item first;
    private Item last;

    // construct an empty deque
    public Deque() {
        size = 0;
        first = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {

    }

    // add the item to the back
    public void addLast(Item item) {

    }

    // remove and return the item from the front
    public Item removeFirst() {
        return first;
    }

    // remove and return the item from the back
    public Item removeLast() {
        return last;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {

    }

    // unit testing (required)
    public static void main(String[] args) {
        
    }

}
