/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * Write a Stack or Queue client that takes a command-line argument k and prints the kth from the
 * last string found on standard input ( assuming that standard input has k or more strings). Use
 * memory proportional to k.
 */
public class Fifteen {

    static String processArgument(int k, String[] args) {
        FixedCapacityQueue<String>
                queue = new FixedCapacityQueue<>(k);

        for (String arg : args) {
            queue.enqueue(arg);
        }

        return queue.dequeue();
    }

    public static void main(String[] args) {
        int k = 5;
        String[] strings = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        System.out.println(processArgument(k, strings));

    }
}
