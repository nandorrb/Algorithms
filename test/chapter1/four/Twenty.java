/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     23/02/2025
 **************************************************************************** */

package test.chapter1.four;

/**
 * 1.4.20 Bitonic search. An array is bitonic if it is comprised of an increasing sequence of
 * integers followed immediately by a decreasing sequence of integers.
 * Write a program that, given  a  bitonic array of N distinct int values, determines whether a
 * given integer is in the array. Your
 * program should use ~3lg N compares in the worst case.
 * Extra credit: Use ~2lg N compares in the worst case.
 */
public class Twenty {

    public static boolean bitonicSearch(int[] a, int key) {
        int max = findMax(a);
        int left = binarySearch(a, key, 0, max, true);
        int right = binarySearch(a, key, max + 1, a.length - 1, false);
        return left != -1 || right != -1;
    }

    private static int binarySearch(int[] a, int key, int i, int max, boolean b) {
        int lo = i;
        int hi = max;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key) {
                return mid;
            }

            if (b) {
                if (a[mid] > key) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            else {
                if (a[mid] < key) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }

    private static int findMax(int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid == 0 || mid == a.length - 1) {
                return mid;
            }

            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return mid;
            }
            else if (a[mid - 1] < a[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5, 7, 9, 8, 6, 4, 2 };
        System.out.println(bitonicSearch(a, 10));

    }
}
