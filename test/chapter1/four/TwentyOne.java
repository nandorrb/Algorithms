/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     23/02/2025
 **************************************************************************** */

package test.chapter1.four;

import java.util.Arrays;

/**
 * 1.4.21
 * Binary search on distinct values. Develop an implementation of binary search for StaticSETofInts
 * (see page 99) where the running time of  contains is guaranteed to be ~lg R, where R is the
 * number of different integers in the array given as argument to the constructor.
 */
public class TwentyOne {

    private int[] a;

    /**
     * Initializes a set of integers specified by the integer array.
     *
     * @param keys the array of integers
     * @throws IllegalArgumentException if the array contains duplicate integers
     */
    public TwentyOne(int[] keys) {

        // defensive copy
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i];

        // sort the integers
        Arrays.sort(a);

        // check for duplicates
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i - 1])
                throw new IllegalArgumentException("Argument arrays contains duplicate keys.");
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }


    public int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int key = 5;
        TwentyOne twentyOne = new TwentyOne(a);
        System.out.println(twentyOne.contains(key));
    }
}
