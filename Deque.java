/* *****************************************************************************
 *  Name: Courtney Hoppus
 *  Date: 2021-01-15
 *  Description: Assignment 1
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private ItemNode front = new ItemNode();
    private ItemNode end = new ItemNode();

    /* construct an empty deque */
    public Deque() {
        size = 0;
        front.next = end;
        end.prev = front;
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
        addNode(front, item);
    }

    /* add the item to the back */
    public void addLast(Item item) {
        addNode(end, item);
    }

    private ItemNode nodeAt(int position) {
        ItemNode current;
        if (position <= size / 2) {
            current = front.next;
            for (int idx = 0; idx < position; idx++) {
                current = current.next;
            }
            return current;
        }
        else {
            current = end.prev;
            for (int idx = size; idx > position; idx--) {
                current = current.prev;
            }
            return current;
        }
    }

    private void addNode(ItemNode node, Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        ItemNode newNode = new ItemNode(item);
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    /* remove and return the item from the front */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            Item item = front.next.item;
            removeNode(nodeAt(1));
            return item;
        }
    }

    /* remove and return the item from the back */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            Item item = end.prev.item;
            removeNode(nodeAt(size - 1));
            return item;
        }
    }

    private void removeNode(ItemNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /* return an iterator over items in order from front to back */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    /* unit testing (required) */
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                deque.addLast(item);
            }
            else if (!deque.isEmpty()) {
                StdOut.print(deque.removeFirst() + " ");
            }
            StdOut.println("(" + deque.size() + " remaining items in queue)");
        }
    }

    /* private class to create ItemNode objects */
    private class ItemNode {
        public Item item;
        public ItemNode prev, next;

        public ItemNode(Item item, ItemNode prev, ItemNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public ItemNode(Item item) {
            this(item, null, null);
        }

        public ItemNode() {
            this(null, null, null);
        }
    }

    /* private class to create DequeIterator object */
    private class DequeIterator implements Iterator<Item> {
        private ItemNode current;

        public DequeIterator() {
            current = front.next;
        }

        public boolean hasNext() {
            return current != end;
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
