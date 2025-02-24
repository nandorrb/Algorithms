/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     23/02/2025
 **************************************************************************** */

package test.chapter1.four;

public class TwentyTwo2 {

    public static boolean fibonacciSearch(int[] arr, int x) {
        int n = arr.length;

        // Initialize Fibonacci numbers
        int fibMMm2 = 0; // (m-2)'th Fibonacci number
        int fibMMm1 = 1; // (m-1)'th Fibonacci number
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci number

        // fibM is going to store the smallest Fibonacci number greater than or equal to n
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // Marks the eliminated range from front
        int offset = -1;

        // While there are elements to be inspected
        while (fibM > 1) {
            // Check if fibMMm2 is a valid location
            int i = Math.min(offset + fibMMm2, n - 1);

            // If x is greater than the value at index fibMMm2, cut the subarray array from offset to i
            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }
            // If x is less than the value at index fibMMm2, cut the subarray after i+1
            else if (arr[i] > x) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }
            // Element found. Return true
            else {
                return true;
            }
        }

        // Comparing the last element with x
        if (fibMMm1 == 1 && arr[offset + 1] == x) {
            return true;
        }

        // Element not found. Return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
        int x = 85;
        System.out.println(fibonacciSearch(arr, x)); // Output: true
    }
}