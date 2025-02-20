/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     16/02/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 1.4.14
 * 4-sum. Develop an algorithm for the 4-sum problem.
 */
public class Fourteen {
    public class FourSum {

        // Do not instantiate.
        private FourSum() {
        }

        /**
         * Prints to standard output the (i, j, k) with {@code i < j < k}
         * such that {@code a[i] + a[j] + a[k] == 0}.
         *
         * @param a the array of integers
         */
        public static void printAll(int[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if (a[i] + a[j] + a[k] + a[l] == 0) {
                                StdOut.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l]);
                            }
                        }
                    }
                }
            }
        }

        /**
         * Returns the number of triples (i, j, k) with {@code i < j < k}
         * such that {@code a[i] + a[j] + a[k] == 0}.
         *
         * @param a the array of integers
         * @return the number of triples (i, j, k) with {@code i < j < k}
         * such that {@code a[i] + a[j] + a[k] == 0}
         */
        public static int count(int[] a) {
            int n = a.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if (a[i] + a[j] + a[k] + a[l] == 0) {
                                count++;
                            }
                        }
                    }
                }
            }
            return count;
        }

        /**
         * Reads in a sequence of integers from a file, specified as a command-line argument;
         * counts the number of triples sum to exactly zero; prints out the time to perform
         * the computation.
         *
         * @param args the command-line arguments
         */
        public static void main(String[] args) {
            In in = new In(args[0]);
            int[] a = in.readAllInts();

            Stopwatch timer = new Stopwatch();
            int count = count(a);
            StdOut.println("elapsed time = " + timer.elapsedTime());
            StdOut.println(count);
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, -10, -20, -11, -12 };
        System.out.println("4-sum: ");
        FourSum.printAll(a);
    }
}
