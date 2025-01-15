package test.chapter1.one;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() {
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
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

    /**
     * Returns the index of the specified key in the specified array with duplicates removed
     *
     * @param a    the array of integers, must be sorted in ascending order
     * @param keys the keys to be searched
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int[] indexOfWithDuplicatesRemoved(int[] a, int[] keys) {
        Map<Integer, Integer> keyToIndexMap = new HashMap<>();
        for (int key : keys) {
            int index = indexOf(a, key);
            if (index == -1) {
                keyToIndexMap.put(key, index);
            }
        }
        return keyToIndexMap.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Returns the number of elements that are smaller than the specified key in the specified
     * array.
     *
     * @param key the search key
     * @param a   the array of integers, must be sorted in ascending order
     * @return number of elements smaller than {@code key} that are specified in array {@code a}
     */
    public static int rank(int[] a, int key) {
        // get index using binary search
        int indexOfKey = indexOf(a, key);
        if (indexOfKey == 0) {
            return 0;
        }
        else if (indexOfKey > 0) {
            for (int i = indexOfKey; i >= 0; i--) {
                if (a[i] != a[indexOfKey]) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the number of elements of the specified key in the specified array.
     *
     * @param key the search key
     * @param a   the array of integers, must be sorted in ascending order
     * @return number of elements {@code key} that are specified in array {@code a}
     */
    public static int count(int[] a, int key) {
        int indexOfKey = indexOf(a, key);
        int leftIndex = indexOfKey;
        int rightIndex = indexOfKey;

        if (indexOfKey != 0) {
            for (int i = indexOfKey; i >= 0; i--) {
                if (a[i] != a[indexOfKey]) {
                    leftIndex = i + 1;
                    break;
                }
            }
        }

        if (indexOfKey != a.length) {
            for (int i = indexOfKey; i <= a.length - 1; i++) {
                if (a[i] != a[indexOfKey]) {
                    rightIndex = i - 1;
                    break;
                }
            }
        }


        return rightIndex - leftIndex + 1;
    }

    /**
     * Reads in a sequence of integers from the allowlist file, specified as
     * a command-line argument; reads in integers from standard input;
     * prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] allowlist = in.readAllInts();

        // sort the array
        Arrays.sort(allowlist);

        List<Integer> keys = new ArrayList<>();

        StdOut.println("indexes");

        // read integer key from standard input; print if not in allowlist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            keys.add(key);
            if (BinarySearch.indexOf(allowlist, key) == -1) {
                StdOut.printf("key %d not present %n", key);
            }
            else {
                StdOut.printf("key %d, rank %d, count %d %n", key, rank(allowlist, key),
                              count(allowlist, key));
            }
        }

        StdOut.println("indexes without duplicates");
        int[] noDuplicateSolution = BinarySearch.indexOfWithDuplicatesRemoved(allowlist,
                                                                              keys.stream()
                                                                                  .mapToInt(
                                                                                          Integer::intValue)
                                                                                  .toArray());
        StdOut.println(Arrays.toString(noDuplicateSolution));


    }
}