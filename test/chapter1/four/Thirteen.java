/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     16/02/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Transaction;

/**
 * 1.4.13
 * Using the assumptions developed in the text , give the amount of memory needed to represent an
 * object of each of the following types:
 * Accumulator, Transaction, FixedCapacityStackOfInts, Point2D, Interval1D, Interval2D, Double
 */
public class Thirteen {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        // 16 bytes overhead
        // 4 bytes for a reference to an int
        // 8 bytes for a reference to a double
        // 8 bytes for a reference to a double
        // total = 36 bytes

        // Transaction
        Transaction transaction;
        // 16 bytes overhead
        // 8 bytes for a reference to a String
        // 8 bytes for a reference to a Date
        // 8 bytes for a double
        // total = 40 bytes

        // FixedCapacityStackOfInts with capacity capacity and n entries
        // FixedCapacityStackOfInts fixedCapacityStackOfInts;
        // 16 bytes overhead
        // 24 +4n bytes for an array of n integers
        // 4 bytes for int capacity
        // 4 bytes for int n
        // total = 44 + 4n bytes

        // Point2D
        Point2D point2D;
        // 16 bytes overhead
        // 8 bytes for a double
        // 8 bytes for a double
        // 16 bytes overhead for each Comparator
        // total = 16 + 8 + 8 + 16 + 16 + 16 = 80 bytes

        // Interval1D
        Interval1D interval1D;
        // 16 bytes overhead
        // 8 bytes for a double
        // 8 bytes for a double
        // 16 bytes overhead for each Comparator
        // total = 16 + 8 + 8 + 16 + 16 + 16 = 80 bytes

        // Interval2D
        Interval2D interval2D;
        // 16 bytes overhead
        // 2 times Interval1D
        // total = 16 + 2 * 80 = 176 bytes

        // Double
        Double aDouble;
        // 16 bytes overhead
        // 8 bytes for a double
        // total = 16 + 8 = 24 bytes
    }
}
