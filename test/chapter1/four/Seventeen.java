/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     16/02/2025
 **************************************************************************** */

package test.chapter1.four;

import java.util.Arrays;

/**
 * 1.4.17 Farthest pair (in one dimension). Write a program that, given an array a[] of N double
 * values, finds a farthest  pair: two values whose difference is no smaller than the difference of
 * any other pair (in absolute value). The running time of your program should be linear in the
 * worst case.
 */
public class Seventeen {

    public static void farthestPairImperative(double[] a) {
        // Sort the array
        double[] sortedArray = Arrays.stream(a).sorted().toArray();

        // Initialize variables to track the closest pair
        double maxDiff = -1;
        int positionOfTheBiggestValue = 0;

        // Find the closest pair
        for (int i = 0; i < sortedArray.length - 1; i++) {
            double diff = sortedArray[i + 1] - sortedArray[i];
            if (diff > maxDiff) {
                maxDiff = diff;
                positionOfTheBiggestValue = i;
            }
        }

        // Print the closest pair
        System.out.println(
                "The farthest pair is: " + sortedArray[positionOfTheBiggestValue] + " and "
                        + sortedArray[positionOfTheBiggestValue + 1]);
    }


    public static void main(String[] args) {
        double[] a = {
                6.6,
                1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 6.5
        };
        farthestPairImperative(a);

    }
}
