/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     9/03/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import test.chapter1.three.FixedCapacityStack;

/**
 * 1.4.37
 * autovioxig  penalty
 */
public class ThirtySeven {

    public static void main(String[] args) {
        // int x = 10;


        // public static void main(String[] args) {
        for (long n = 250; true; n += n) {
            FixedCapacityStackOfInts stack1 = new FixedCapacityStackOfInts(5);
            FixedCapacityStack<Integer> stack2 = new FixedCapacityStack<>(5);
            Stopwatch timer = new Stopwatch();
            for (int i = 0; i < n; i++) {
                stack1.push(i);
                stack1.pop();
            }
            double time1 = timer.elapsedTime();
            Stopwatch timer2 = new Stopwatch();
            for (int i = 0; i < n; i++) {
                stack2.push(i);
                stack2.pop();
            }
            double time2 = timer2.elapsedTime();


            StdOut.printf("%d %f %f %f \n", n, time1, time2, time2 / time1);
        }
        // }

    }
}
