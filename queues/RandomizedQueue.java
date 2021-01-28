/* *****************************************************************************
 *  Name: Courtney Hoppus
 *  Date: 2021-01-15
 *  Description: Assignment 1
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        items = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }


    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIdx = StdRandom.uniform(size);
        Item item = items[randomIdx];
        if (randomIdx != size) {
            items[randomIdx] = items[size];
        }
        items[size--] = null;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        Item[] aux = (Item[]) new Object[capacity];
        for (int idx = 0; idx < size; idx++) {
            aux[idx] = items[idx];
        }
        items = aux;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIdx = StdRandom.uniform(size);
        return items[randomIdx];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private Item[] aux = (Item[]) new Object[items.length];
        private int auxSize = size;

        public RandomQueueIterator() {
            for (int idx = 0; idx < items.length; idx++) {
                aux[idx] = items[idx];
            }
        }

        public boolean hasNext() {
            return auxSize > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int randomIdx = StdRandom.uniform(auxSize);
            Item item = aux[randomIdx];
            if (randomIdx != auxSize - 1) {
                aux[randomIdx] = aux[auxSize - 1];
            }
            aux[auxSize - 1] = null;
            auxSize--;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> random = new RandomizedQueue<>();
        random.enqueue("Betty Wetter");
        random.enqueue("Cookie Couture");
        random.enqueue("Beau Degas");
        random.enqueue("Angel Baby");
        random.enqueue("Arson Nicki");
        random.enqueue("Miss Texas");
        StdOut.println(random.size());
        Iterator<String> itr = random.iterator();
        while (itr.hasNext()) {
            StdOut.println(itr.next());
        }
        StdOut.println("Is it empty = " + random.isEmpty());
        StdOut.println(random.sample());
        StdOut.println(random.dequeue());
        StdOut.println(random.dequeue());
        StdOut.println(random.size());

    }

}
