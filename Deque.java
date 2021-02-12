/* *****************************************************************************
 *  Name: Courtney Hoppus
 *  Date: 2021-01-15
 *  Description: Assignment 1
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private ItemNode front, end;

    /* construct an empty deque */
    public Deque() {
        size = 0;
        front = null;
        end = null;
    }

    /* is the deque empty? */
    public boolean isEmpty() {
        return size == 0;
    }

    /* return the number of items on the deque */
    public int size() {
        return size;
    }

    /* add the item to the front */
    public void addFirst(Item item) {
        checkItem(item);
        ItemNode oldFront = front;
        front = new ItemNode(item, null, oldFront);
        if (oldFront != null) {
            oldFront.prev = front;
        }
        else {
            end = front;
        }
        size++;
    }

    /* add the item to the back */
    public void addLast(Item item) {
        checkItem(item);
        ItemNode oldEnd = end;
        end = new ItemNode(item, oldEnd, null);
        if (oldEnd != null) {
            oldEnd.next = end;
        }
        else {
            front = end;
        }
        size++;
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    /* remove and return the item from the front */
    public Item removeFirst() {
        checkDeque();
        ItemNode oldFront = front;
        front = front.next;
        if (front != null) {
            front.prev = null;
        }
        else {
            end = null;
        }
        size--;
        return oldFront.item;
    }

    /* remove and return the item from the back */
    public Item removeLast() {
        checkDeque();
        ItemNode oldEnd = end;
        end = end.prev;
        if (end != null) {
            end.next = null;
        }
        else {
            front = null;
        }
        size--;
        return oldEnd.item;
    }

    private void checkDeque() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    /* return an iterator over items in order from front to back */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    /* unit testing (required) */
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("Betty Wetter");
        deque.addFirst("Cookie Couture");
        deque.addFirst("Beau Degas");
        deque.addLast("Angel Baby");
        deque.addLast("Arson Nicki");
        deque.addLast("Miss Texas");
        for (String s : deque) {
            StdOut.println(s);
        }
        StdOut.println("Is it empty = " + deque.isEmpty());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
        StdOut.println("Deque size = " + deque.size());
    }

    /* private class to create ItemNode objects */
    private class ItemNode {
        private Item item;
        private ItemNode prev, next;

        public ItemNode(Item item, ItemNode prev, ItemNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public ItemNode(Item item) {
            this(item, null, null);
        }
    }

    /* private class to create DequeIterator object */
    private class DequeIterator implements Iterator<Item> {
        private ItemNode current;

        public DequeIterator() {
            current = front;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
