/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     9/02/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1.4.8 Write a program to determine the number pairs of values in an input file that are equal. If
 * your first try is quadratic, think again and use Arrays.sort() to develop a linearithmic
 * solution.
 */
public class Eigth {

    int quadratic(int[] input) {
        int solution = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length - 1; j++) {
                if (input[i] == input[j]) {
                    solution++;
                }
            }
        }
        return solution;
    }

    int linearithmic(int[] input) {
        int solution = 0;
        int[] sortedArray = Arrays.stream(input).sorted().toArray();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (BinarySearch.indexOf(sortedArray, sortedArray[i]) != i) {
                solution++;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int N = 100;
        int[] initialValues = IntStream.generate(() -> StdRandom.uniformInt(100))
                                       .limit(N)
                                       .toArray();

        Eigth e = new Eigth();
        System.out.println("Solution Linearithmic: ");
        System.out.println(e.linearithmic(initialValues));
        System.out.println("Solution Quadratic: ");
        System.out.println(e.quadratic(initialValues));

    }
}
