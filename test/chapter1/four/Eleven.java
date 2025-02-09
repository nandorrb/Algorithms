/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     9/02/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * 1.4.11 Add an instance method howMany() to StaticSETofInts (page 99) that finds the number of
 * occurrences of a given key in time proportional to log N in the worst case.
 */
public class Eleven {
    private class StaticSETofInts {
        private int[] a;

        /**
         * Initializes a set of integers specified by the integer array.
         *
         * @param keys the array of integers
         * @throws IllegalArgumentException if the array contains duplicate integers
         */
        public StaticSETofInts(int[] keys) {

            // defensive copy
            a = new int[keys.length];
            for (int i = 0; i < keys.length; i++)
                a[i] = keys[i];

            // sort the integers
            Arrays.sort(a);
        }

        private int indexOfLowerIndex(int key) {
            int lo = 0;
            int hi = a.length - 1;
            int result = -1;
            while (lo <= hi) {
                // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]) {
                    hi = mid - 1;
                }
                else if (key > a[mid]) {
                    lo = mid + 1;
                }
                else {
                    result = mid;
                    hi = mid - 1; // continue searching in the left half
                }
            }
            return result;
        }

        private int indexOfHigherIndex(int key) {
            int lo = 0;
            int hi = a.length - 1;
            int result = -1;
            while (lo <= hi) {
                // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]) {
                    hi = mid - 1;
                }
                else if (key > a[mid]) {
                    lo = mid + 1;
                }
                else {
                    result = mid;
                    lo = mid + 1; // continue searching in the left half
                }
            }
            return result;
        }

        /**
         * Returns the number of occurrences of the specified key in this set of integers.
         *
         * @param key the search key
         * @return the number of occurrences of the specified key in this set of integers
         */
        public int howMany(int key) {
            return indexOfHigherIndex(key) - indexOfLowerIndex(key) + 1;
        }

        private int[] findIndices(int key) {
            int lo = 0;
            int hi = a.length - 1;
            int lowerIndex = -1;
            int higherIndex = -1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]) {
                    hi = mid - 1;
                }
                else if (key > a[mid]) {
                    lo = mid + 1;
                }
                else {
                    lowerIndex = mid;
                    higherIndex = mid;
                    // Find lower index
                    int tempHi = mid - 1;
                    while (lo <= tempHi) {
                        int tempMid = lo + (tempHi - lo) / 2;
                        if (key == a[tempMid]) {
                            lowerIndex = tempMid;
                            tempHi = tempMid - 1;
                        }
                        else {
                            lo = tempMid + 1;
                        }
                    }
                    // Find higher index
                    lo = mid + 1;
                    hi = a.length - 1;
                    while (lo <= hi) {
                        int tempMid = lo + (hi - lo) / 2;
                        if (key == a[tempMid]) {
                            higherIndex = tempMid;
                            lo = tempMid + 1;
                        }
                        else {
                            hi = tempMid - 1;
                        }
                    }
                    break;
                }
            }
            return new int[] { lowerIndex, higherIndex };
        }

        /**
         * Returns the number of occurrences of the specified key in this set of integers.
         *
         * @param key the search key
         * @return the number of occurrences of the specified key in this set of integers
         */
        public int howMany2(int key) {
            int[] indices = findIndices(key);
            if (indices[0] == -1) {
                return 0; // key not found
            }
            return indices[1] - indices[0] + 1;
        }
    }

    public static void main(String[] args) {

        // create a set of integers
        for (int N = 250; true; N += N) {
            int[] keys = new int[N];
            for (int i = 0; i < N; i++) {
                keys[i] = StdRandom.uniformInt(-10000, 10000);
            }
            int key = StdRandom.uniformInt(-10000, 10000);
            System.out.println("N: " + N);
            StaticSETofInts set = new Eleven().new StaticSETofInts(keys);

            System.out.println("Number of occurrences of : " + key);
            Stopwatch timer = new Stopwatch();
            System.out.println(set.howMany(key));
            System.out.println("Elapsed time: " + timer.elapsedTime());

            System.out.println("Number of occurrences of : " + key);
            Stopwatch timer2 = new Stopwatch();
            System.out.println(set.howMany2(key));
            System.out.println("Elapsed time: " + timer2.elapsedTime());
        }
    }
}
