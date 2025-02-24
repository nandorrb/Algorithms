/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     23/02/2025
 **************************************************************************** */

package test.chapter1.four;

public class TwentyTwo3 {

    int fibonacciSearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        // Initializing Fibonacci numbers
        int k2 = 0;
        int k1 = 1;
        int k0 = k1 + k2; // Fibonacci sequence

        // Generate smallest Fibonacci number greater than or equal to array length
        while (k0 < a.length) {
            k2 = k1;
            k1 = k0;
            k0 = k1 + k2;
        }

        while (k0 > 1) {
            int mid = Math.min(lo + k2, hi); // Prevent out-of-bounds access

            if (a[mid] == key) {
                return mid;
            }
            else if (a[mid] < key) {
                lo = mid + 1;
                k0 = k1;
                k1 = k2;
                k2 = k0 - k1;
            }
            else {
                hi = mid - 1;
                k0 = k2;
                k1 -= k2;
                k2 = k0 - k1;
            }
        }

        // If the last element is the key
        if (k1 == 1 && lo < a.length && a[lo] == key) {
            return lo;
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        TwentyTwo3 twentyTwo3 = new TwentyTwo3();
        System.out.println(twentyTwo3.fibonacciSearch(a, 2)); // Output: 7
    }
}
