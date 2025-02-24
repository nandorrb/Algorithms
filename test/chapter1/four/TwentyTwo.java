/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     23/02/2025
 **************************************************************************** */

package test.chapter1.four;

/**
 * 1.4.22
 * Binary search with only addition and subtraction. [Mihai Patrascu] Write a program that, given an
 * array of N
 * distinct int values in ascending order, determines whether a given integer is in the array. You
 * may use only additions and subtractions and a constant amount of extra memory. The running time
 * of your program should be proportional to log N in the worst case.
 */
public class TwentyTwo {
    static int fibonnacciSearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int k0 = 1;
        int k1 = 1;
        int k2 = 0;
        while (k0 <= a[hi]) {
            k2 = k1;
            k1 = k0;
            k0 = k1 + k2;
        }

        while (lo <= hi) {

            int newK2 = k0 - k1;
            k0 = k1;
            k1 = k2;
            k2 = newK2;

            int mid = Math.min(Math.max(lo + k2, lo), hi);
            if (a[mid] == key) {
                return mid;
            }
            else if (a[mid] < key) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        System.out.println(TwentyTwo.fibonnacciSearch(a, 10));

    }
}
