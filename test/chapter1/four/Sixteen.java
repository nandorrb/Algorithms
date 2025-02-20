/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     16/02/2025
 **************************************************************************** */

package test.chapter1.four;

import java.util.Arrays;

/**
 * 1.4.16 Closest pair (in one dimension). Write a program that, given an array a[] of N double
 * values, finds a closest pair: two values whose difference is no greater than the difference
 * of any other pair (in absolute value). The running time of your program should be linearithmic in
 * the worst case.
 */
public class Sixteen {

    public static void closestPairImperative(double[] a) {
        // Sort the array
        double[] sortedArray = Arrays.stream(a).sorted().toArray();

        // Initialize variables to track the closest pair
        double minDiff = Double.MAX_VALUE;
        int positionOfTheSmallestValue = 0;

        // Find the closest pair
        for (int i = 0; i < sortedArray.length - 1; i++) {
            double diff = sortedArray[i + 1] - sortedArray[i];
            if (diff < minDiff) {
                minDiff = diff;
                positionOfTheSmallestValue = i;
            }
        }

        // Print the closest pair
        System.out.println(
                "The closest pair is: " + sortedArray[positionOfTheSmallestValue] + " and "
                        + sortedArray[positionOfTheSmallestValue + 1]);
    }


    public static void main(String[] args) {
        double[] a = {
                6.6,
                1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 6.5
        };
        closestPairImperative(a);

    }
}
