/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randoQ = new RandomizedQueue<String>();
        int num = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            randoQ.enqueue(StdIn.readString());
        }
        for (int idx = 0; idx < num; idx++) {
            StdOut.println(randoQ.dequeue());
        }
    }
}
