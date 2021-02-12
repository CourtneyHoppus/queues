/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomQ = new RandomizedQueue<String>();
        int num = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            randomQ.enqueue(StdIn.readString());
        }
        while (num > 0) {
            StdOut.println(randomQ.dequeue());
            num--;
        }
    }
}
