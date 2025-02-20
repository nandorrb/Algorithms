/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     16/02/2025
 **************************************************************************** */

package test.chapter1.four;

/**
 * 1.4.18 Local minimum of an array. Write a program that, given an array a[] of N distinct
 * integers, finds a strict local minimum: an index i such that a[i-1] > a[i] < a[i+1]. Your program
 * should use ~2 lg N compares in the worst case.
 */
public class Eighteen {
    // TODO: Implement localMinimum method
    public static int localMinimum(int[] a) {
        // int lo = 0;
        // int hi = a.length - 1;
        //
        // while (lo <= hi) {
        //     int mid = lo + (hi - lo) / 2;
        //
        //     if (mid == 0 || mid == a.length - 1) {
        //         return mid;
        //     }
        //
        //     if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
        //         return mid;
        //     }
        //     else if (a[mid - 1] < a[mid + 1]) {
        //         hi = mid - 1;
        //     }
        //     else {
        //         lo = mid + 1;
        //     }
        // }
        //
        // return -1;
    }


    public static void main(String[] args) {
        int[] a = { 9, 8, 7, 6, 7, 8, 3, 2, 1 };
        System.out.println("Local minimum: " + localMinimum(a));

    }
}
