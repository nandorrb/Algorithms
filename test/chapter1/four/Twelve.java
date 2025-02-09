/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     9/02/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1.4.12 Write a program that, given two sorted arrays of N int values, prints all elements that
 * appear in both arrays, in sorted order. The running time of your program should be proportional
 * to N in the worst case.
 */
public class Twelve {
    static int[] commonElements(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                stack.push(a[i]);
                i++;
                j++;
            }
            else if (a[i] < b[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return IntStream.generate(stack::pop).limit(stack.size())
                        .toArray();
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] b = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };

        System.out.println("Common elements in both arrays: ");
        System.out.println(Arrays.toString(commonElements(a, b)));

    }
}
